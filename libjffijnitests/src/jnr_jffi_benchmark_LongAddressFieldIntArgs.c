#include "jffi_jni_tests.h"

#include "jnr_jffi_benchmark_LongAddressFieldIntArgs.h"

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldIntArgs
 * Method:    call_void
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_jnr_jffi_benchmark_LongAddressFieldIntArgs_call_1void
  (JNIEnv *env, jobject self) {
    addresssink = getLong2PointerValue(env, self);
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldIntArgs
 * Method:    call_int
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressFieldIntArgs_call_1int
  (JNIEnv *env, jobject self) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldIntArgs
 * Method:    call_int__1int
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressFieldIntArgs_call_1int_1_11int
  (JNIEnv *env, jobject self, jint arg0) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldIntArgs
 * Method:    call_int__2int
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressFieldIntArgs_call_1int_1_12int
  (JNIEnv *env, jobject self, jint arg0, jint arg1) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldIntArgs
 * Method:    call_int__3int
 * Signature: (III)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressFieldIntArgs_call_1int_1_13int
  (JNIEnv *env, jobject self, jint arg0, jint arg1, jint arg2) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldIntArgs
 * Method:    call_int__4int
 * Signature: (IIII)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressFieldIntArgs_call_1int_1_14int
  (JNIEnv *env, jobject self, jint arg0, jint arg1, jint arg2, jint arg3) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldIntArgs
 * Method:    call_int__5int
 * Signature: (IIIII)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressFieldIntArgs_call_1int_1_15int
  (JNIEnv *env, jobject self, jint arg0, jint arg1, jint arg2, jint arg3, jint arg4) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

/*
 * Class:     jnr_jffi_benchmark_LongAddressFieldIntArgs
 * Method:    call_int__6int
 * Signature: (IIIIII)I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_benchmark_LongAddressFieldIntArgs_call_1int_1_16int
  (JNIEnv *env, jobject self, jint arg0, jint arg1, jint arg2, jint arg3, jint arg4, jint arg5) {
    addresssink = getLong2PointerValue(env, self);
    return 0;
}

#ifdef __cplusplus
}
#endif