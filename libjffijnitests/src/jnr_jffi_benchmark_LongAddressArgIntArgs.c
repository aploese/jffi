#include "jffi_jni_tests.h"


#include "jnr_jffi_benchmark_LongAddressArgIntArgs.h"

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     jnr_jffi_benchmark_LongAddressArgIntArgs
 * Method:    call_void0
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_jnr_jffi_benchmark_LongAddressArgIntArgs_call_1void0
  (JNIEnv *env, jclass cls, jlong address) {
    addresssink = (void *)address; 
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgIntArgs
 * Method:    call_int0
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressArgIntArgs_call_1int0
  (JNIEnv *env, jclass cls, jlong address) {
    addresssink = (void *)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgIntArgs
 * Method:    call_int__1int0
 * Signature: (JI)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressArgIntArgs_call_1int_1_11int0
  (JNIEnv *env, jclass cls, jlong address, jint arg0) {
    addresssink = (void *)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgIntArgs
 * Method:    call_int__2int0
 * Signature: (JII)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressArgIntArgs_call_1int_1_12int0
  (JNIEnv *env, jclass cls, jlong address, jint arg0, jint arg1) {
    addresssink = (void *)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgIntArgs
 * Method:    call_int__3int0
 * Signature: (JIII)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressArgIntArgs_call_1int_1_13int0
  (JNIEnv *env, jclass cls, jlong address, jint arg0, jint arg1, jint arg2) {
    addresssink = (void *)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgIntArgs
 * Method:    call_int__4int0
 * Signature: (JIIII)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressArgIntArgs_call_1int_1_14int0
  (JNIEnv *env, jclass cls, jlong address, jint arg0, jint arg1, jint arg2, jint arg3) {
    addresssink = (void *)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgIntArgs
 * Method:    call_int__5int0
 * Signature: (JIIIII)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressArgIntArgs_call_1int_1_15int0
  (JNIEnv *env, jclass cls, jlong address, jint arg0, jint arg1, jint arg2, jint arg3, jint arg4) {
    addresssink = (void *)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgIntArgs
 * Method:    call_int__6int0
 * Signature: (JIIIIII)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressArgIntArgs_call_1int_1_16int0
  (JNIEnv *env, jclass cls, jlong address, jint arg0, jint arg1, jint arg2, jint arg3, jint arg4, jint arg5) {
    addresssink = (void *)address; 
    return 0;
}

#ifdef __cplusplus
}
#endif