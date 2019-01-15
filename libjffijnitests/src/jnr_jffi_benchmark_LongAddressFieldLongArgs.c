#include "jffi_jni_tests.h"

#include "jnr_jffi_benchmark_LongAddressFieldLongArgs.h"

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldLongArgs
 * Method:    call_void
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_jnr_jffi_benchmark_LongAddressFieldLongArgs_call_1void
  (JNIEnv *env, jobject self) {
    addresssink = getLong2PointerValue(env, self);
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldLongArgs
 * Method:    call_long
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressFieldLongArgs_call_1long
  (JNIEnv *env, jobject self) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldLongArgs
 * Method:    call_long__1long
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressFieldLongArgs_call_1long_1_11long
  (JNIEnv *env, jobject self, jlong arg0) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldLongArgs
 * Method:    call_long__2long
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressFieldLongArgs_call_1long_1_12long
  (JNIEnv *env, jobject self, jlong arg0, jlong arg1) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldLongArgs
 * Method:    call_long__3long
 * Signature: (JJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressFieldLongArgs_call_1long_1_13long
  (JNIEnv *env, jobject self, jlong arg0, jlong arg1, jlong arg2) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldLongArgs
 * Method:    call_long__4long
 * Signature: (JJJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressFieldLongArgs_call_1long_1_14long
  (JNIEnv *env, jobject self, jlong arg0, jlong arg1, jlong arg2, jlong arg3) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldLongArgs
 * Method:    call_long__5long
 * Signature: (JJJJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressFieldLongArgs_call_1long_1_15long
  (JNIEnv *env, jobject self, jlong arg0, jlong arg1, jlong arg2, jlong arg3, jlong arg4) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldLongArgs
 * Method:    call_long__6long
 * Signature: (JJJJJJ)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_benchmark_LongAddressFieldLongArgs_call_1long_1_16long
  (JNIEnv *env, jobject self, jlong arg0, jlong arg1, jlong arg2, jlong arg3, jlong arg4, jlong arg5) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

#ifdef __cplusplus
}
#endif