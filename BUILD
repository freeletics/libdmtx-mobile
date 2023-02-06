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

package(default_visibility = ["//visibility:public"])

config_setting(
    name = "android",
    values = {"crosstool_top": "@androidndk//:default_crosstool"},
    visibility = ["//visibility:public"],
)

config_setting(
    name = "android_x86",
    values = {
        "crosstool_top": "@androidndk//:default_crosstool",
        "cpu": "x86",
    },
    visibility = ["//visibility:public"],
)

config_setting(
    name = "android_x86_64",
    values = {
        "crosstool_top": "@androidndk//:default_crosstool",
        "cpu": "x86_64",
    },
    visibility = ["//visibility:public"],
)

config_setting(
    name = "android_armeabi",
    values = {
        "crosstool_top": "@androidndk//:default_crosstool",
        "cpu": "armeabi",
    },
    visibility = ["//visibility:public"],
)

config_setting(
    name = "android_arm",
    values = {
        "crosstool_top": "@androidndk//:default_crosstool",
        "cpu": "armeabi-v7a",
    },
    visibility = ["//visibility:public"],
)

config_setting(
    name = "android_arm64",
    values = {
        "crosstool_top": "@androidndk//:default_crosstool",
        "cpu": "arm64-v8a",
    },
    visibility = ["//visibility:public"],
)

config_setting(
    name = "ios",
    values = {
        "apple_platform_type": "ios",
    },
    visibility = ["//visibility:public"],
)

config_setting(
    name = "ios_armv7",
    values = {
        "apple_platform_type": "ios",
        "ios_multi_cpus": "armv7",
    },
    visibility = ["//visibility:public"],
)

config_setting(
    name = "ios_armv64",
    values = {
        "apple_platform_type": "ios",
        "ios_multi_cpus": "armv64",
    },
    visibility = ["//visibility:public"],
)

config_setting(
    name = "ios_i386",
    values = {
        "apple_platform_type": "ios",
        "ios_multi_cpus": "i386",
    },
    visibility = ["//visibility:public"],
)

config_setting(
    name = "ios_x86_64",
    values = {
        "apple_platform_type": "ios",
        "ios_multi_cpus": "x86_64",
    },
    visibility = ["//visibility:public"],
)
