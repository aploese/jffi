#include "jffi.h"
#include "Exception.h"

jfieldID LongRef_Value;
jfieldID IntRef_Value;
jfieldID OpaquePointer_pointerValue;
jclass IntegerClass;
jmethodID Integer_valueOf;

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *jvm, void *reserved) {
    JNIEnv *env;
    if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_1_2)) {
        return JNI_ERR;
    }

    //Get field IDs
    jclass LongRef = (*env)->FindClass(env, "jnr/jffi/types/LongRef");
    if (LongRef == NULL) {
        return JNI_ERR;
    }
    LongRef_Value = (*env)->GetFieldID(env, LongRef, "value", "J");
    if (LongRef_Value == NULL) {
        return JNI_ERR;
    }
    (*env)->DeleteLocalRef(env, LongRef);


    jclass IntRef = (*env)->FindClass(env, "jnr/jffi/types/IntRef");
    if (IntRef == NULL) {
        return JNI_ERR;
    }
    IntRef_Value = (*env)->GetFieldID(env, IntRef, "value", "I");
    if (IntRef_Value == NULL) {
        return JNI_ERR;
    }
    (*env)->DeleteLocalRef(env, IntRef);

    jclass OpaquePointerClass = NULL;
    OpaquePointerClass = (*env)->FindClass(env, "jnr/jffi/spi/OpaquePointer");
    if (OpaquePointerClass == NULL) {
        return JNI_ERR;
    }
    OpaquePointer_pointerValue = (*env)->GetFieldID(env, OpaquePointerClass, "pointerValue", "J");
    if (OpaquePointer_pointerValue == NULL) {
        return JNI_ERR;
    }
    (*env)->DeleteLocalRef(env, OpaquePointerClass);

    jclass localIntegerClass = (*env)->FindClass(env, "java/lang/Integer");
    if (localIntegerClass == NULL) {
        return JNI_ERR;
    }
    IntegerClass = (*env)->NewGlobalRef(env, localIntegerClass);
    if (IntegerClass == NULL) {
        return JNI_ERR;
    }
    (*env)->DeleteLocalRef(env, localIntegerClass);

    Integer_valueOf = (*env)->GetStaticMethodID(env, IntegerClass, "valueOf", "(I)Ljava/lang/Integer;");
    if (Integer_valueOf == NULL) {
        return JNI_ERR;
    }

    // mark that the lib was loaded
    jclass posixLibraryLoaderImpl = (*env)->FindClass(env,
            "jnr/jffi/spi/AbstractLibraryLoader");
    if (posixLibraryLoaderImpl == NULL) {
        return JNI_ERR;
    }
    jfieldID posixLibraryLoaderImpl_libLoaded = (*env)->GetStaticFieldID(env,
            posixLibraryLoaderImpl, "libLoaded", "Z");
    if (posixLibraryLoaderImpl_libLoaded == NULL) {
        return JNI_ERR;
    }

    (*env)->SetStaticBooleanField(env, posixLibraryLoaderImpl,
            posixLibraryLoaderImpl_libLoaded, JNI_TRUE);

    (*env)->DeleteLocalRef(env, posixLibraryLoaderImpl);


    return JNI_VERSION_1_4;
}

JNIEXPORT void JNICALL
JNI_OnUnload(JavaVM *jvm, void *reserved) {
    JNIEnv *env;
    LongRef_Value = 0;
    IntRef_Value = 0;
    OpaquePointer_pointerValue = 0;


    if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_1_2)) {
        return;
    }

    // mark that the lib was unloaded
    jclass posixLibraryLoaderImpl = (*env)->FindClass(env,
            "jnr/jffi/spi/AbstractLibraryLoader");
    if (posixLibraryLoaderImpl != NULL) {
        jfieldID posixLibraryLoaderImpl_libLoaded = (*env)->GetStaticFieldID(env,
                posixLibraryLoaderImpl, "libLoaded", "Z");
        (*env)->SetStaticBooleanField(env, posixLibraryLoaderImpl,
                posixLibraryLoaderImpl_libLoaded, JNI_FALSE);
    }
    (*env)->DeleteLocalRef(env, posixLibraryLoaderImpl);
    (*env)->DeleteGlobalRef(env, IntegerClass);

}

jobject wrapInteger(JNIEnv *env, int value) {
    return (*env)->CallStaticObjectMethod(env, IntegerClass, Integer_valueOf, value);
}
