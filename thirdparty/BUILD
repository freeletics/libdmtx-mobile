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

load("@rules_cc//cc:defs.bzl", "cc_library")

package(default_visibility = ["//visibility:public"])

"""

bazel build -c opt --linkopt="-s" --strip=ALWAYS --config=android_arm //thirdparty:libdmtx

"""

alias(
    name = "libdmtx",
    actual = "@libdmtx//:libdmtx",
    visibility = ["//visibility:public"],
)
