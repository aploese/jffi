#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.69])
AC_INIT([jffitests], [0.0.0], [aploese@gmx.de])
AM_INIT_AUTOMAKE([-Wall -Werror])
AM_MAINTAINER_MODE

AM_PROG_AR

LT_INIT()
AC_CONFIG_SRCDIR()
AC_CONFIG_HEADERS([config.h])
AC_CONFIG_MACRO_DIRS([m4])

AC_CHECK_SIZEOF([size_t])


# Checks for programs.
AC_PROG_CC
AC_PROG_INSTALL

LDFLAGS="$LDFLAGS --no-undefined"

# Checks for typedefs, structures, and compiler characteristics.

# Checks for library functions.


AC_CONFIG_FILES([Makefile src/Makefile])

AC_OUTPUT
