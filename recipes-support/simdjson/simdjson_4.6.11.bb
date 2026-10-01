SUMMARY = "Extremely fast C++ JSON parser using SIMD instructions"
DESCRIPTION = "simdjson is a JSON parsing and serialization library that runs \
at gigabytes per second by using SIMD instructions (SSE4/AVX2/NEON/etc). \
It is used by fastgltf as its (only) hard dependency for parsing glTF JSON."
HOMEPAGE = "https://simdjson.org"
BUGTRACKER = "https://github.com/simdjson/simdjson/issues"
SECTION = "libs"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=08ad3d5aa0308e4e47849861fbb9da7b"

SRC_URI = "git://github.com/simdjson/simdjson.git;protocol=https;branch=master;tag=v${PV}"

SRCREV = "f5de14f09256982933af2849beb43778bd421ca7"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "\
    -DBUILD_SHARED_LIBS=ON \
    -DSIMDJSON_SINGLEHEADER=ON \
    -DSIMDJSON_DEVELOPER_MODE=OFF \
    -DSIMDJSON_ENABLE_THREADS=ON \
"
