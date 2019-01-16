#include "jffi_jni_tests.h"


#include "jnr_jffi_benchmark_IntAddressArgLongArgs.h"

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     jnr_jffi_benchmark_IntAddressArgLongArgs
 * Method:    call_void0
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_jnr_jffi_benchmark_IntAddressArgLongArgs_call_1void0
  (JNIEnv *env, jclass cls, jint address) {
    addresssink = (void *)(uintptr_t)address; 
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgLongArgs
 * Method:    call_long0
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_IntAddressArgLongArgs_call_1long0
  (JNIEnv *env, jclass cls, jint address) {
    addresssink = (void *)(uintptr_t)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgLongArgs
 * Method:    call_long__1long0
 * Signature: (IJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_IntAddressArgLongArgs_call_1long_1_11long0
  (JNIEnv *env, jclass cls, jint address, jlong arg0) {
    addresssink = (void *)(uintptr_t)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgLongArgs
 * Method:    call_long__2long0
 * Signature: (IJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_IntAddressArgLongArgs_call_1long_1_12long0
  (JNIEnv *env, jclass cls, jint address, jlong arg0, jlong arg1) {
    addresssink = (void *)(uintptr_t)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgLongArgs
 * Method:    call_long__3long0
 * Signature: (IJJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_IntAddressArgLongArgs_call_1long_1_13long0
  (JNIEnv *env, jclass cls, jint address, jlong arg0, jlong arg1, jlong arg2) {
    addresssink = (void *)(uintptr_t)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgLongArgs
 * Method:    call_long__4long0
 * Signature: (IJJJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_IntAddressArgLongArgs_call_1long_1_14long0
  (JNIEnv *env, jclass cls, jint address, jlong arg0, jlong arg1, jlong arg2, jlong arg3) {
    addresssink = (void *)(uintptr_t)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgLongArgs
 * Method:    call_long__5long0
 * Signature: (IJJJJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_IntAddressArgLongArgs_call_1long_1_15long0
  (JNIEnv *env, jclass cls, jint address, jlong arg0, jlong arg1, jlong arg2, jlong arg3, jlong arg4) {
    addresssink = (void *)(uintptr_t)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgLongArgs
 * Method:    call_long__6long0
 * Signature: (IJJJJJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_IntAddressArgLongArgs_call_1long_1_16long0
  (JNIEnv *env, jclass cls, jint address, jlong arg0, jlong arg1, jlong arg2, jlong arg3, jlong arg4, jlong arg5) {
    addresssink = (void *)(uintptr_t)address; 
    return 0;
}

#ifdef __cplusplus
}
#endif