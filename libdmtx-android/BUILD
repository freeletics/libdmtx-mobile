#    libdmtx-mobile - libdmtx port to Android and iOS
#
#    Copyright (C) 2023 Freeletics
#
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <https://www.gnu.org/licenses/>.
licenses(["notice"])

exports_files(["COPYING"])

load("@rules_android//android:rules.bzl", "android_binary", "android_library")
load("//libdmtx-android:aar_with_jni.bzl", "aar_with_jni")

"""
Build with command

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

"""

aar_with_jni(
    name = "libdmtx-android",
    android_library = ":libdmtx-android-lib",
)

android_library(
    name = "libdmtx-android-lib",
    srcs = glob(["src/**/*.java"]),
    custom_package = "org.libdmtx",
    manifest = "AndroidManifest.xml",
    resource_files = glob(["res/**/*"]),
    deps = [
        ":libdmtx-android-jni",
    ],
)

cc_binary(
    name = "dmtx-android",
    srcs = glob(["jni/*.c", "jni/*.h"]),
    linkshared = True,
    linkstatic = True,
    deps = [
        "//thirdparty:libdmtx"
    ],
)

cc_library(
    name = "libdmtx-android-jni",
    hdrs = glob(["jni/*.h"]),
    srcs = [":dmtx-android"],
    alwayslink = 1,
)
