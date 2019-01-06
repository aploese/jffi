CC=gcc
top_builddir=../../..
JFFI_LIB_BUILD_DIR=$(top_builddir)/target/native-jni-lib
JFFI_LIB_OUT_DIR=$(top_builddir)/src/main/resources
SRC_DIR=.

LIBTOOL=$(SHELL) $(top_builddir)/libtool
LIBNAME=libjffi.la

JFFI_SRCS = $(wildcard $(SRC_DIR)/*.c)
JFFI_OBJS := $(patsubst $(SRC_DIR)/%.c, $(JFFI_LIB_BUILD_DIR)/%.o, $(JFFI_SRCS))
JFFI_LINKER_OBJECTS := $(subst .c,.lo, $(JFFI_OBJS))

LIBJFFI = $(JFFI_LIB_OUT_DIR)/$(LIBNAME)

JNI_INCLUDED_JFFI_HEADER=-I$(top_builddir)/target/generated-sources/main/native/include

all:	$(LIBJFFI)

$(JFFI_LIB_BUILD_DIR)/%.o : $(SRC_DIR)/%.c
	@mkdir -p $(@D)
	$(LIBTOOL) --mode=compile $(CC) -g -O2 -pthread -fPIC  -I/usr/lib/jvm/java-11-openjdk-amd64/include -I/usr/lib/jvm/java-11-openjdk-amd64/include/linux $(JNI_INCLUDED_JFFI_HEADER) -c $< -o $@


$(LIBJFFI):  $(JFFI_OBJS)
	@mkdir -p $(@D)
	$(LIBTOOL) --mode=link $(CC) -o $(LIBJFFI) -pthread $(JFFI_LINKER_OBJECTS) -Wl,--no-undefined -lffi -ldl -rpath /tmp

clean::
	rm -rf $(JFFI_LIB_BUILD_DIR)
	rm -f $(LIBJFFI)

debug::
	@echo "SRCS=$(JFFI_SRCS)"
	@echo "LIBJFFI=$(LIBJFFI)"
	@echo "JFFI_LINKER_OBJECTS=$(JFFI_LINKER_OBJECTS)"
	@echo "JNI_INCLUDE_FLAGS= -I/usr/lib/jvm/java-11-openjdk-amd64/include -I/usr/lib/jvm/java-11-openjdk-amd64/include/linux"
	@echo "JNI_INCLUDED_HEADER=$(JNI_INCLUDED_HEADER)"
