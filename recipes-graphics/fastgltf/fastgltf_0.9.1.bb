SUMMARY = "A modern C++17/C++20 glTF 2.0 library focused on speed, correctness and usability"
DESCRIPTION = "fastgltf is a speed and usability focused glTF 2.0 library \
written in modern C++17 (optionally C++20) with minimal dependencies. It uses \
SIMD to accelerate parsing/loading of glTF data and supports the full glTF \
2.0 spec, including many vendor and Khronos extensions."
HOMEPAGE = "https://github.com/spnda/fastgltf"
BUGTRACKER = "https://github.com/spnda/fastgltf/issues"
SECTION = "libs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=52fdb946d85220bc6396b1dc8f170460"

SRC_URI = "git://github.com/spnda/fastgltf.git;protocol=https;branch=main;tag=v${PV}"

SRCREV = "705564d4d54500ae88befb0db9e361e447923655"

S = "${WORKDIR}/git"

DEPENDS = "simdjson"

inherit cmake

EXTRA_OECMAKE += "\
    -DBUILD_SHARED_LIBS=ON \
    -DFASTGLTF_ENABLE_INSTALL=ON \
    -DFASTGLTF_ENABLE_TESTS=OFF \
    -DFASTGLTF_ENABLE_EXAMPLES=OFF \
    -DFASTGLTF_ENABLE_DOCS=OFF \
    -DFASTGLTF_ENABLE_GLTF_RS=OFF \
    -DFASTGLTF_ENABLE_ASSIMP=OFF \
"

PACKAGECONFIG ??= ""
PACKAGECONFIG[cpp20] = "-DFASTGLTF_COMPILE_AS_CPP20=ON,-DFASTGLTF_COMPILE_AS_CPP20=OFF"
PACKAGECONFIG[cpp-modules] = "-DFASTGLTF_ENABLE_CPP_MODULES=ON,-DFASTGLTF_ENABLE_CPP_MODULES=OFF"
PACKAGECONFIG[implicit-shapes] = "-DFASTGLTF_ENABLE_KHR_IMPLICIT_SHAPES=ON,-DFASTGLTF_ENABLE_KHR_IMPLICIT_SHAPES=OFF"
PACKAGECONFIG[physics-rigid-bodies] = "-DFASTGLTF_ENABLE_KHR_PHYSICS_RIGID_BODIES=ON,-DFASTGLTF_ENABLE_KHR_PHYSICS_RIGID_BODIES=OFF"
PACKAGECONFIG[64bit-float] = "-DFASTGLTF_USE_64BIT_FLOAT=ON,-DFASTGLTF_USE_64BIT_FLOAT=OFF"
PACKAGECONFIG[custom-smallvector] = "-DFASTGLTF_USE_CUSTOM_SMALLVECTOR=ON,-DFASTGLTF_USE_CUSTOM_SMALLVECTOR=OFF"
PACKAGECONFIG[no-memory-pool] = "-DFASTGLTF_DISABLE_CUSTOM_MEMORY_POOL=ON,-DFASTGLTF_DISABLE_CUSTOM_MEMORY_POOL=OFF"
