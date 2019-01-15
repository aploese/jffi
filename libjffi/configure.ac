#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.69])
AC_INIT([jffi], [0.0.0], [aploese@gmx.de])
AM_INIT_AUTOMAKE([-Wall -Werror])
AM_MAINTAINER_MODE

AM_PROG_AR

LT_INIT([disable-static dlopen])
AC_CONFIG_SRCDIR()
AC_CONFIG_HEADERS([config.h])
AC_CONFIG_MACRO_DIRS([m4])

AC_CHECK_SIZEOF([size_t])
AC_C_BIGENDIAN


# Checks for programs.
AC_PROG_CC
AC_PROG_CC_C_O
AC_PROG_INSTALL

AC_ARG_ENABLE([debug],
  [AS_HELP_STRING([--enable-debug],
    [enable debug code (default is no)])],
  [debug="$withval"], [debug=no])

AC_ARG_WITH([jffi-header-dir],
  [AS_HELP_STRING([--with-jffi-header-dir],
    [dir of generated jffi jni headers (default ../target/include)])],
  [JFFI_JNI_HEADER_DIR="$withval"], [JFFI_JNI_HEADER_DIR="\$(top_builddir)/../target/generated-sources/include"])

#TODO check and make absolute path
AC_SUBST(JFFI_JNI_HEADER_DIR)


# Checks for libraries.
AC_SEARCH_LIBS([dlopen], [dl])

CFLAGS="-g -O3 -fstack-protector-strong"

LDFLAGS="$LDFLAGS --no-undefined"

# Checks for header files.
AC_CHECK_HEADERS([stdlib.h limits.h locale.h dlcfn.h])


# Check for jni header files.
AX_JNI_INCLUDE_DIR
AC_SUBST(JNI_INCLUDE_DIRS)
for JNI_INCLUDE_DIR in $JNI_INCLUDE_DIRS
do
    JNI_INCLUDE_FLAGS="$JNI_INCLUDE_FLAGS -I$JNI_INCLUDE_DIR"
done
AC_SUBST(JNI_INCLUDE_FLAGS)

# Checks for typedefs, structures, and compiler characteristics.

# Checks for library functions.


AC_CONFIG_FILES([Makefile src/Makefile])

AC_OUTPUT
