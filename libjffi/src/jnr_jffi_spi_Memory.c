#include "jffi.h"

#include "jnr_jffi_spi_Memory.h"

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     jnr_jffi_spi_Memory
 * Method:    freeMemory
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_jnr_jffi_spi_Memory_freeMemory
  (JNIEnv *env, jobject self) {
    void* memAddress = (void *)(*env)->GetLongField(env, self, OpaquePointer_pointerValue);
    free((void*)memAddress);
}

#ifdef __cplusplus
}