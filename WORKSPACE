workspace(name = "libdmtx-mobile")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")

# libdmtx dependency
http_archive(
    name = "libdmtx",
    urls = ["https://github.com/dmtx/libdmtx/archive/refs/tags/v0.7.5.zip"],
    sha256 = "7c67be07bd5a952733bc47fa17cbb637e0ed8a2bbae78323b48961da0267a772",
    strip_prefix = "libdmtx-0.7.5",
    build_file = "@//thirdparty:libdmtx.BUILD",
)

# Android rules
http_archive(
    name = "rules_android",
    urls = ["https://github.com/bazelbuild/rules_android/archive/v0.1.1.zip"],
    sha256 = "cd06d15dd8bb59926e4d65f9003bfc20f9da4b2519985c27e190cddc8b7a7806",
    strip_prefix = "rules_android-0.1.1",
)

android_sdk_repository(
    name = "androidsdk",
    build_tools_version="30.0.3"
)

android_ndk_repository(
    name = "androidndk",
    api_level = 21
)
register_toolchains("@androidndk//:all")

# Apple rules
git_repository(
    name = "build_bazel_rules_apple",
    remote = "https://github.com/bazelbuild/rules_apple.git",
    tag = "0.32.0",
)

git_repository(
    name = "build_bazel_rules_swift",
    remote = "https://github.com/bazelbuild/rules_swift.git",
    tag = "0.24.0",
)

git_repository(
    name = "build_bazel_apple_support",
    remote = "https://github.com/bazelbuild/apple_support.git",
    tag = "0.11.0",
)

git_repository(
    name = "bazel_skylib",
    remote = "https://github.com/bazelbuild/bazel-skylib.git",
    tag = "1.1.1",
)
