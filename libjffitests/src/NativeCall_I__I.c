#include <errno.h>
#include "jffitests.h"

#ifdef __cplusplus
extern "C" {
#endif

    int jnr_jffi_test_NativeCall_SI__SI_negate(int arg0) {
        return ~arg0;
    }

    unsigned int jnr_jffi_test_NativeCall_UI__UI_negate(unsigned int arg0) {
        return ~arg0;
    }
    
    int jnr_jffi_test_NativeCall_SI__SI_read_write_error(int error) {
        int result = errno;
        errno = error;
        return result;
    }


#ifdef __cplusplus
}
#endif