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

load("@build_bazel_rules_apple//apple:ios.bzl", "ios_static_framework")


"""
Build with command

bazel build //libdmtx-ios:libdmtx --apple_platform_type=ios

"""

objc_library(
    name = "libdmtx-wrapper",
    hdrs = glob(["wrapper/SHDataMatrixReader.h"]),
    srcs = glob(["wrapper/SHDataMatrixReader.m"]),
    deps = [
        "//thirdparty:libdmtx"
    ]
)

ios_static_framework(
    name = "libdmtx",
    hdrs = glob(["wrapper/SHDataMatrixReader.h"]),
    minimum_os_version = "10.0",
    deps = [
        ":libdmtx-wrapper"
    ],
)
