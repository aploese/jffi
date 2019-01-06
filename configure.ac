#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.69])
AC_INIT([libjffi], [VERSION], [BUG-REPORT-ADDRESS])

LT_PREREQ([2.4.6])
LT_INIT()

AC_CANONICAL_BUILD
AC_CANONICAL_HOST

# AC_CONFIG_SRCDIR([src/main/native/Array.c])
AC_CONFIG_HEADERS([config.h])

# Checks for programs.
AC_PROG_CC
AC_PROG_LIBTOOL
AC_CONFIG_MACRO_DIR([m4])
# Checks for libraries.

# Checks for header files.
AC_FUNC_ALLOCA
AC_CHECK_HEADERS([limits.h locale.h malloc.h stdint.h stdlib.h string.h sys/param.h unistd.h])

# Check for jni header files.
AX_JNI_INCLUDE_DIR
AC_SUBST(JNI_INCLUDE_DIRS)
for JNI_INCLUDE_DIR in $JNI_INCLUDE_DIRS
do
    JNI_INCLUDE_FLAGS="$JNI_INCLUDE_FLAGS -I$JNI_INCLUDE_DIR"
done
AC_SUBST(JNI_INCLUDE_FLAGS)

TARGET_DIR="/target"
AC_SUBST(TARGET_DIR)


MULTIARCH_DIR=CC --print-multiarch
AC_SUBST(MULTIARCH_DIR)

JNI_INCLUDED_JFFI_HEADER=$TARGET_DIR/generated-sources/main/native/include
AC_SUBST(JNI_INCLUDED_JFFI_HEADER)

JFFI_LIB_BUILD_DIR=$TARGET_DIR/native-jni-lib
AC_SUBST(JFFI_LIB_BUILD_DIR)
JFFI_LIB_OUT_DIR=/src/main/resources
AC_SUBST(JFFI_LIB_OUT_DIR)

TEST_BUILD_DIR=$TARGET_DIR/native-tests
AC_SUBST(TEST_BUILD_DIR)
TEST_OUT_DIR=$TARGET_DIR/test-classes
AC_SUBST(TEST_OUT_DIR)




# Checks for typedefs, structures, and compiler characteristics.
AC_CHECK_HEADER_STDBOOL
AC_C_INLINE
AC_TYPE_INT16_T
AC_TYPE_INT32_T
AC_TYPE_INT64_T
AC_TYPE_INT8_T
AC_TYPE_SIZE_T
AC_TYPE_UINT16_T
AC_TYPE_UINT32_T
AC_TYPE_UINT64_T
AC_TYPE_UINT8_T

# Checks for library functions.
AC_FUNC_MALLOC
AC_FUNC_MMAP
AC_CHECK_FUNCS([memchr memmove memset munmap strerror])

AC_CONFIG_FILES(src/main/native/Makefile src/test/native/Makefile)

LT_OUTPUT
AC_OUTPUT
