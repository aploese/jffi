#include "jffi_jni_tests.h"

jfieldID IntAddress_address;    
jfieldID LongAddress_address;    
volatile void *addresssink;

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *jvm, void *reserved) {
    JNIEnv *env;
    if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_1_2)) {
        return JNI_ERR;
    }

    
    jclass IntAddressClass = (*env)->FindClass(env, "jnr/jffi/benchmark/IntAddress");
    if (IntAddressClass == NULL) {
        return JNI_ERR;
    }
    IntAddress_address = (*env)->GetFieldID(env, IntAddressClass, "address", "I");
    if (IntAddress_address == NULL) {
        return JNI_ERR;
    }
    (*env)->DeleteLocalRef(env, IntAddressClass);

    
    jclass LongAddressClass = (*env)->FindClass(env, "jnr/jffi/benchmark/LongAddress");
    if (LongAddressClass == NULL) {
        return JNI_ERR;
    }
    LongAddress_address = (*env)->GetFieldID(env, LongAddressClass, "address", "J");
    if (LongAddress_address == NULL) {
        return JNI_ERR;
    }
    (*env)->DeleteLocalRef(env, LongAddressClass);

    return JNI_VERSION_1_4;
}

JNIEXPORT void JNICALL
JNI_OnUnload(JavaVM *jvm, void *reserved) {
}