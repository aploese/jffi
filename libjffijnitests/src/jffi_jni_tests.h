#ifndef  _Included_jffi_jni_tests_H
#define _Included_jffi_jni_tests_H
#include <config.h>

#include <stdint.h>

#include <jni.h>


extern jfieldID IntAddress_address;    
extern jfieldID LongAddress_address;
extern volatile void *addresssink;

inline void * getInt2PointerValue(JNIEnv *env, jobject intAddress) {
    return (void *)(uintptr_t)(*env)->GetIntField(env, intAddress, IntAddress_address);
}

inline void * getLong2PointerValue(JNIEnv *env, jobject longAddress) {
    return (void *)(uintptr_t)(*env)->GetLongField(env, longAddress, LongAddress_address);
}

#endif