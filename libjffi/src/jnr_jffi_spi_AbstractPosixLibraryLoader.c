#include <jffi.h>

#include "jnr_jffi_spi_AbstractPosixLibraryLoader.h"

#include <dlfcn.h>

#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     jnr_jffi_spi_AbstractPosixLibraryLoader
 * Method:    RTLD_LAZY
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_spi_AbstractPosixLibraryLoader_RTLD_1LAZY
  (JNIEnv *env, jobject self) {
    return RTLD_LAZY;
}

/*
 * Class:     jnr_jffi_spi_AbstractPosixLibraryLoader
 * Method:    RTLD_NOW
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_spi_AbstractPosixLibraryLoader_RTLD_1NOW
  (JNIEnv *env, jobject self) {
    return RTLD_NOW;
}

/*
 * Class:     jnr_jffi_spi_AbstractPosixLibraryLoader
 * Method:    RTLD_BINDING_MASK
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_spi_AbstractPosixLibraryLoader_RTLD_1BINDING_1MASK
  (JNIEnv *env, jobject self) {
    return RTLD_BINDING_MASK;
}

/*
 * Class:     jnr_jffi_spi_AbstractPosixLibraryLoader
 * Method:    RTLD_NOLOAD
 * Signature: ()Ljava/lang/Integer;
 */
JNIEXPORT jobject JNICALL Java_jnr_jffi_spi_AbstractPosixLibraryLoader_RTLD_1NOLOAD
  (JNIEnv *env, jobject self) {
#ifdef RTLD_NOLOAD
    return wrapInteger(env, RTLD_NOLOAD);
#else 
    return NULL;
#endif
}

/*
 * Class:     jnr_jffi_spi_AbstractPosixLibraryLoader
 * Method:    RTLD_DEEPBIND
 * Signature: ()Ljava/lang/Integer;
 */
JNIEXPORT jobject JNICALL Java_jnr_jffi_spi_AbstractPosixLibraryLoader_RTLD_1DEEPBIND
  (JNIEnv *env, jobject self) {
#ifdef RTLD_DEEPBIND
    return wrapInteger(env, RTLD_DEEPBIND);
#else 
    return NULL;
#endif
}

/*
 * Class:     jnr_jffi_spi_AbstractPosixLibraryLoader
 * Method:    RTLD_GLOBAL
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_spi_AbstractPosixLibraryLoader_RTLD_1GLOBAL
  (JNIEnv *env, jobject self) {
    return RTLD_GLOBAL;
}

/*
 * Class:     jnr_jffi_spi_AbstractPosixLibraryLoader
 * Method:    RTLD_LOCAL
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_jnr_jffi_spi_AbstractPosixLibraryLoader_RTLD_1LOCAL
  (JNIEnv *env, jobject self) {
    return RTLD_LOCAL;
}

/*
 * Class:     jnr_jffi_spi_AbstractPosixLibraryLoader
 * Method:    RTLD_NODELETE
 * Signature: ()Ljava/lang/Integer;
 */
JNIEXPORT jobject JNICALL Java_jnr_jffi_spi_AbstractPosixLibraryLoader_RTLD_1NODELETE
  (JNIEnv *env, jobject self) {
#ifdef RTLD_NODELETE
    return wrapInteger(env, RTLD_NODELETE);
#else 
    return NULL;
#endif
}

/*
 * Class:     jnr_jffi_spi_AbstractPosixLibraryLoader
 * Method:    RTLD_MEMBER
 * Signature: ()Ljava/lang/Integer;
 */
JNIEXPORT jobject JNICALL Java_jnr_jffi_spi_AbstractPosixLibraryLoader_RTLD_1MEMBER
  (JNIEnv *env, jobject self) {
#ifdef RTLD_MEMBER
    return wrapInteger(env, RTLD_MEMBER);
#else 
    return NULL;
#endif
}

/*
 * Class:     jnr_jffi_spi_AbstractPosixLibraryLoader
 * Method:    RTLD_NOAUTODEFER
 * Signature: ()Ljava/lang/Short;
 */
JNIEXPORT jobject JNICALL Java_jnr_jffi_spi_AbstractPosixLibraryLoader_RTLD_1NOAUTODEFER
  (JNIEnv *env, jobject self) {
#ifdef RTLD_NOAUTODEFER
    return wrapInteger(env, RTLD_NOAUTODEFER);
#else 
    return NULL;
#endif
}

#ifdef __cplusplus
}
#endif