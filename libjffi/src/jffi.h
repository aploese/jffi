#ifndef _jffi_H
#define _jffi_H

#include <jni.h>

#include <config.h>

#include <stdint.h>

/**
 * Field for 
 */
extern jfieldID LongRef_Value; /* id for field 'value'  */
extern jfieldID IntRef_Value; /* id for field 'value'  */
/** Global Ref keep this here so class AbstractFunction wont be unloaded and AbstractFunction_Handle stays valid.
 */

extern jfieldID OpaquePointer_pointerValue;

inline void * getPointerValue(JNIEnv *env, jobject opaquePointer) {
    return (void *)(uintptr_t)(*env)->GetLongField(env, opaquePointer, OpaquePointer_pointerValue);
}

/** Global Ref
 */
extern jclass IntegerClass;
extern jmethodID Integer_valueOf;

extern jobject wrapInteger(JNIEnv *env, int value);


#endif
