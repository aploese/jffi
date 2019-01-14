#include "jffi.h"
#include <locale.h>

#include <dlfcn.h>
#include <stdlib.h>


#include "jnr_jffi_spi_PosixLibraryLoaderImpl.h"

#include "Exception.h"

#ifdef __cplusplus
extern "C" {
#endif

    /*
     * Class:     jnr_jffi_spi_PosixLibraryLoaderImpl
     * Method:    dlopen
     * Signature: (Ljava/lang/String;I)J
     */
    JNIEXPORT jlong JNICALL Java_jnr_jffi_spi_PosixLibraryLoaderImpl_dlopen
    (JNIEnv *env, jobject self, jstring jLibName, jint flags) {
        void* result = NULL;
        const char* libName = (*env)->GetStringUTFChars(env, jLibName, NULL);
        result = dlopen(libName, flags);
        if (result == NULL) {
            locale_t myLocale = newlocale(LC_ALL, "C", (locale_t) 0);
            locale_t old_locale = uselocale(myLocale);
            throwException(env, UnsatisfiedLink, "Opening Lib dlopen \"%s\" with flags: 0x%08x\n\tMSG: %s", libName, flags, dlerror());
            uselocale(old_locale);
            freelocale(myLocale);
        }
        (*env)->ReleaseStringUTFChars(env, jLibName, libName);

        return (jlong)(uintptr_t)result;
    }

        /*
     * Class:     jnr_jffi_spi_PosixLibraryLoaderImpl
     * Method:    dlsym
     * Signature: (JLjava/lang/String;)J
     */
    JNIEXPORT jlong JNICALL Java_jnr_jffi_spi_PosixLibraryLoaderImpl_dlsym
    (JNIEnv *env, jobject self, jlong libHandle, jstring jFuncName) {
        void* result = NULL;
        const char* funcName = (*env)->GetStringUTFChars(env, jFuncName, NULL);
        result = dlsym((void*) libHandle, funcName);
        if (result == NULL) {
            throwException(env, UnsatisfiedLink, "Find Function Address %s %s", funcName, dlerror());
        }

        //TODO TEST BEGIN
//        int value = ((int (*)(int)) (result))(((int) 22));
//        throwException(env, UnsatisfiedLink, "Function Return value %s %i", funcName, value);
        //TODO TEST END
        
        (*env)->ReleaseStringUTFChars(env, jFuncName, funcName);
        return (jlong)(uintptr_t)result;
    }

    /*
     * Class:     jnr_jffi_spi_PosixLibraryLoaderImpl
     * Method:    dlclose
     * Signature: (J)I
     */
    JNIEXPORT jint JNICALL Java_jnr_jffi_spi_PosixLibraryLoaderImpl_dlclose
    (JNIEnv *env, jobject self, jlong handle) {
        int result = 0;
        result = dlclose((void*)(uintptr_t)handle);
        if (result != 0) {
            throwException(env, UnsatisfiedLink, "Closing %s", dlerror());
        }

        return (jint) result;
    }

/*
 * Class:     jnr_jffi_spi_PosixLibraryLoaderImpl
 * Method:    malloc
 * Signature: (J)J
 */
JNIEXPORT jlong JNICALL Java_jnr_jffi_spi_PosixLibraryLoaderImpl_malloc
  (JNIEnv *env, jobject self, jlong size) {
    return (jlong)malloc(size);
}

#ifdef __cplusplus
}
#endif