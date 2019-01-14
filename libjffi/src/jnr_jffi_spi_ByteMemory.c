#include "jffi.h"

#include"jnr_jffi_spi_ByteMemory.h"

#ifdef __cplusplus
extern "C" {
#endif

/*
     * Class:     jnr_jffi_spi_ByteMemory
     * Method:    getByteValue0
     * Signature: (J)B
     */
    JNIEXPORT jbyte JNICALL Java_jnr_jffi_spi_ByteMemory_getByteValue0
    (JNIEnv *env, jobject self, jlong address) {
        return *(((jbyte *)address));
    }

    /*
     * Class:     jnr_jffi_spi_ByteMemory
     * Method:    setByteValue0
     * Signature: (JB)V
     */
    JNIEXPORT void JNICALL Java_jnr_jffi_spi_ByteMemory_setByteValue0
    (JNIEnv *env, jobject self, jlong address, jbyte newValue) {
        *((jbyte *)address) = newValue;

    }

#ifdef __cplusplus
}
#endif