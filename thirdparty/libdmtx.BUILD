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

cc_library(
    name = "libdmtx_src",
    srcs = glob(["dmtx.c"]),
    hdrs = glob(["dmtx.h"]),
    textual_hdrs = [ "dmtxencode.c", "dmtxencodestream.c", "dmtxencodescheme.c",
	    "dmtxencodeoptimize.c", "dmtxencodeascii.c", "dmtxencodec40textx12.c",
	    "dmtxencodeedifact.c", "dmtxencodebase256.c", "dmtxdecode.c", "dmtxdecodescheme.c",
	    "dmtxmessage.c", "dmtxregion.c", "dmtxsymbol.c", "dmtxplacemod.c", "dmtxreedsol.c",
	    "dmtxscangrid.c", "dmtximage.c", "dmtxbytelist.c", "dmtxtime.c", "dmtxvector2.c",
	    "dmtxmatrix3.c", "dmtxstatic.h" ],
    include_prefix = "include",
    copts = ["-Wshadow", "-Wall", "-pedantic", "-std=c99", "-Iexternal/libdmtx"],
    linkopts = ["-lm"],
)

alias(
    name = "libdmtx",
    actual = ":libdmtx_src",
    visibility = ["//visibility:public"],
)
