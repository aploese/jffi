#include "jffi.h"

#include "jnr_jffi_spi_function_NativeCall_I__I__Impl.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
     * Class:     jnr_jffi_spi_function_NativeCall_I__I__Impl
     * Method:    call_i__i
     * Signature: (I)I
     */
    JNIEXPORT jint JNICALL Java_jnr_jffi_spi_function_NativeCall_1I_1_1I_1_1Impl_call_1i_1_1i
    (JNIEnv *env, jobject self, jint arg0) {
        void *functionHandle = getPointerValue(env, self);
        return ((int (*)(int)) functionHandle)(arg0);
    }

    /*
     * Class:     jnr_jffi_spi_function_NativeCall_I__I__Impl
     * Method:    call_i__i
     * Signature: (JI)I
     *
    JNIEXPORT jint JNICALL Java_jnr_jffi_spi_function_NativeCall_1I_1_1I_1_1Impl_call_1i_1_1i
        (JNIEnv *env, jobject self, jlong address,jint arg0) {
        return (jint) ((int (*)(int)) (address))(((int) arg0));
        }
     */
#ifdef __cplusplus
}
#endif