# libdmtx-mobile

Port of [libdmtx][1] and [libdmtx-wrappers][2] for Java and Cocoa to Android
and iOS respectively.

## How to use

### Android

```kotlin
import org.libdmtx.DMTXImage

val bitmap = //.. obtain android.graphics.Bitmap in ARGB_8888 format from Camera or Gallery

// retrieve raw image data to DMTXImage
val dmtxImage = run {
  val dmtxBufferArray = IntArray(bitmap.width * bitmap.height)
  bitmap.getPixels(dmtxBufferArray, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
  DMTXImage(bitmap.width, bitmap.height, dmtxBufferArray)
}
// find 1 data matrix tag with 2000ms timeout
val tags = dmtxImage.getTags(1, 2000)
if (tags.isEmpty()) {
  // no data matrix found
} else {
  // retrieve output result
  val result = tags.first().id
}
```

### iOS

```swift
import libdmtx

let image = //... obtain an UIImage from Camera or Gallery in ARGB8 format

let result = (SHDataMatrixReader.sharedDataMatrixReader() as! SHDataMatrixReader).decodeBarcode(from: image)

// result is non-empty NSString, nil if decoding is unsuccessfull

```

## Building

### Android

*Requirements*

- Bazel 5.2.0 or newer.
- Android SDK and environment variable `ANDROID_HOME` set to its path if not
  set.
- Android SDK build tools 30.0.3.
- Android NDK `21.4.7075529` and environment variable `ANDROID_NDK_HOME` set to
  its path.

*Building artifacts*

Build AAR containing all binaries with:

```
bazel build -c opt --strip=ALWAYS \
    --host_crosstool_top=@bazel_tools//tools/cpp:toolchain \
    --fat_apk_cpu=arm64-v8a,armeabi-v7a,x86,x86_64 \
    --legacy_whole_archive=0 \
    --features=-legacy_whole_archive \
    --copt=-fvisibility=hidden \
    --copt=-ffunction-sections \
    --copt=-fdata-sections \
    --copt=-fstack-protector \
    --copt=-Oz \
    --copt=-fomit-frame-pointer \
    --copt=-DABSL_MIN_LOG_LEVEL=2 \
    --linkopt=-Wl,--gc-sections,--strip-all \
    //libdmtx-android:libdmtx-android
```

Resulting AAR should be in `bazel-bin/libdmtx-android/libdmtx-android.aar`. JNI
`.so` binaries are inside AAR's `jni` folder. These files are single shared
libraries with libdmtx and the JNI wrapper.

Individual `.so` files for dynamic loading without JNI wrapper can be build with:

```
bazel build //thirdparty:libdmtx --config=android_arm
```

Acceptable values for `--config` are `android_arm`, `android_arm64`,
`android_x86`, `android_x86_64`. Resulting `.so` will be in
`bazel-bin/external/libdmtx` folder.

### iOS

*Requirements*

- Bazel 5.2.0 or newer
- Xcode command line tools
- **You might need to comment the Android SDK/NDK lines in the `WORKSPACE` file.**

*Building artifacts*

Build the single libdmtx static frameworks with the following commands:

```
bazel build -c opt //libdmtx-ios:libdmtx --config=ios_arm64 // phone
bazel build -c opt //libdmtx-ios:libdmtx --config=ios_x86_64 // simulator
bazel build -c opt //libdmtx-ios:libdmtx --config=ios_sim_arm64 // arm64 simulator
```

* Acceptable values for `--config` are `ios_armv7`, `ios_arm64`, `ios_i386`,
  `ios_x86_64`, `ios_sim_arm64`, `ios_sim_universal` (both `x86_64` and `sim_arm64`).
* The resulting `.framework` can be extracted from the `libdmtx.zip` file
  located at the respective
  `bazel-out/applebin_ios-ios_<arch>*/bin/libdmtx-ios/` path.

Build `.xcframework` with the following script. It will first build individual
frameworks for `arm64` and combined `sim_arm64` and `x86_64` targets and then
package them to XCframework. Output `libdmtx.xcframework` will be in the root
folder.

```
./scripts/buildXCFramework.sh
```


[1]: https://github.com/dmtx/libdmtx
[2]: https://github.com/dmtx/dmtx-wrappers
