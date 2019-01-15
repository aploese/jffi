#include "jffi_jni_tests.h"

#include "jnr_jffi_benchmark_LongAddressArgLongArgs.h"

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     jnr_jffi_benchmark_LongAddressArgLongArgs
 * Method:    call_void0
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_jnr_jffi_benchmark_LongAddressArgLongArgs_call_1void0
  (JNIEnv *env, jclass cls, jlong address) {
    addresssink = (void *)address; 
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgLongArgs
 * Method:    call_long0
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressArgLongArgs_call_1long0
  (JNIEnv *env, jclass cls, jlong address) {
    addresssink = (void *)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgLongArgs
 * Method:    call_long__1long0
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressArgLongArgs_call_1long_1_11long0
  (JNIEnv *env, jclass cls, jlong address, jlong arg0) {
    addresssink = (void *)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgLongArgs
 * Method:    call_long__2long0
 * Signature: (JJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressArgLongArgs_call_1long_1_12long0
  (JNIEnv *env, jclass cls, jlong address, jlong arg1, jlong arg2) {
    addresssink = (void *)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgLongArgs
 * Method:    call_long__3long0
 * Signature: (JJJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressArgLongArgs_call_1long_1_13long0
  (JNIEnv *env, jclass cls, jlong address, jlong arg0, jlong arg1, jlong arg2) {
    addresssink = (void *)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgLongArgs
 * Method:    call_long__4long0
 * Signature: (JJJJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressArgLongArgs_call_1long_1_14long0
  (JNIEnv *env, jclass cls, jlong address, jlong arg0, jlong arg1, jlong arg2, jlong arg3) {
    addresssink = (void *)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgLongArgs
 * Method:    call_long__5long0
 * Signature: (JJJJJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressArgLongArgs_call_1long_1_15long0
  (JNIEnv *env, jclass cls, jlong address, jlong arg0, jlong arg1, jlong arg2, jlong arg3, jlong arg4) {
    addresssink = (void *)address; 
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressArgLongArgs
 * Method:    call_long__6long0
 * Signature: (JJJJJJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressArgLongArgs_call_1long_1_16long0
  (JNIEnv *env, jclass cls, jlong address, jlong arg0, jlong arg1, jlong arg2, jlong arg3, jlong arg4, jlong arg5) {
    addresssink = (void *)address; 
    return 0;
}

#ifdef __cplusplus
}
#endif