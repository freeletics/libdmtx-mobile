#!/bin/bash
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

set -e

# clean build output
bazel clean

# build phone framework
echo "Building arm64 framework..."
bazel build -c opt //libdmtx-ios:libdmtx --config=ios_arm64
mkdir -p phone
libdmtxOut=$(find -L bazel-out -name libdmtx.zip)
unzip $libdmtxOut -d ./phone/

# clean build output
bazel clean

# build simulator framework
echo "Building sim_arm64 + x86_64 framework..."
bazel build -c opt //libdmtx-ios:libdmtx --config=ios_sim_universal
mkdir -p simulator
libdmtxOut=$(find -L bazel-out -name libdmtx.zip)
unzip $libdmtxOut -d ./simulator/

# merge them to XCframework
echo "Packaging XCFramework..."
xcodebuild -create-xcframework \
-framework ./phone/libdmtx.framework \
-framework ./simulator/libdmtx.framework \
-output ./tmp_libdmtx.xcframework

mv tmp_libdmtx.xcframework libdmtx.xcframework

rm -rf ./phone
rm -rf ./simulator
echo "Finished"
