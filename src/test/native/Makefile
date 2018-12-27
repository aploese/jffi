CC=gcc
top_builddir=../../..
TEST_BUILD_DIR=$(top_builddir)/target/native-tests
TEST_OUT_DIR=$(top_builddir)/target/test-classes
SRC_DIR=.
LIBTOOL=$(SHELL) $(top_builddir)/libtool
LIBNAME=libtest.la


TEST_SRCS = $(wildcard $(SRC_DIR)/*.c)
TEST_OBJS := $(patsubst $(SRC_DIR)/%.c, $(TEST_BUILD_DIR)/%.o, $(TEST_SRCS))
TEST_LINKER_OBJECTS := $(subst .c,.lo, $(TEST_OBJS))

LIBTEST = $(TEST_OUT_DIR)/$(LIBNAME)

all:	$(LIBTEST)

$(TEST_BUILD_DIR)/%.o : $(SRC_DIR)/%.c
	@mkdir -p $(@D)
	$(LIBTOOL) --mode=compile $(CC) -fPIC -g -O2 -c $< -o $@


$(LIBTEST):  $(TEST_OBJS)
	@mkdir -p $(@D)
	$(LIBTOOL) --mode=link $(CC) -o $(LIBTEST) $(TEST_LINKER_OBJECTS) -rpath /tmp

clean::
	rm -rf $(TEST_BUILD_DIR)
	rm -f $(LIBTEST)

debug::
	@echo "SRCS=$(TEST_SRCS)"
	@echo "LIBTEST=$(LIBTEST)"
	@echo "TEST_LINKER_OBJECTS=$(TEST_LINKER_OBJECTS)"
