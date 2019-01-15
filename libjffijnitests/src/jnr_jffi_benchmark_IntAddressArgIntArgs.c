#include "jffi_jni_tests.h"

#include "jnr_jffi_benchmark_IntAddressArgIntArgs.h"

#ifdef __cplusplus
extern "C" {
#endif
    
/*
 * Class:     jnr_jffi_benchmark_IntAddressArgIntArgs
 * Method:    call_void0
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_jnr_jffi_benchmark_IntAddressArgIntArgs_call_1void0
  (JNIEnv *env, jclass cls, jint address) {
    addresssink = (void *)(long)address; 
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgIntArgs
 * Method:    call_int0
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_IntAddressArgIntArgs_call_1int0
  (JNIEnv *env, jclass cls, jint address) {
    addresssink = (void *)(long)address;
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgIntArgs
 * Method:    call_int__1int0
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_IntAddressArgIntArgs_call_1int_1_11int0
  (JNIEnv *env, jclass cls, jint address, jint arg0) {
    addresssink = (void *)(long)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgIntArgs
 * Method:    call_int__2int0
 * Signature: (III)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_IntAddressArgIntArgs_call_1int_1_12int0
  (JNIEnv *env, jclass cls, jint address, jint arg0, jint arg1) {
    addresssink = (void *)(long)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgIntArgs
 * Method:    call_int__3int0
 * Signature: (IIII)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_IntAddressArgIntArgs_call_1int_1_13int0
  (JNIEnv *env, jclass cls, jint address, jint arg0, jint arg1, jint arg2) {
    addresssink = (void *)(long)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgIntArgs
 * Method:    call_int__4int0
 * Signature: (IIIII)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_IntAddressArgIntArgs_call_1int_1_14int0
  (JNIEnv *env, jclass cls, jint address, jint arg0, jint arg1, jint arg2, jint arg3) {
    addresssink = (void *)(long)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgIntArgs
 * Method:    call_int__5int0
 * Signature: (IIIIII)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_IntAddressArgIntArgs_call_1int_1_15int0
  (JNIEnv *env, jclass cls, jint address, jint arg0, jint arg1, jint arg2, jint arg3, jint arg4) {
    addresssink = (void *)(long)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_IntAddressArgIntArgs
 * Method:    call_int__6int0
 * Signature: (IIIIIII)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_IntAddressArgIntArgs_call_1int_1_16int0
  (JNIEnv *env, jclass cls, jint address, jint arg0, jint arg1, jint arg2, jint arg3, jint arg4, jint arg5) {
    addresssink = (void *)(long)address; 
    return 0;
}

#ifdef __cplusplus
}
#endif
