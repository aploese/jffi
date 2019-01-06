/* 
 * Copyright (C) 2008-2010 Wayne Meissner
 * 
 * This file is part of jffi.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * 
 * Alternatively, you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this work.  If not, see <http://www.gnu.org/licenses/>.
 */

#include <stdlib.h>
#ifndef _WIN32
#  include <pthread.h>
#endif
#include <signal.h>
#include <jni.h>
#include "Exception.h"
#include "com_kenai_jffi_Foreign.h"
#include "jffi.h"
#include "FaultProtect.h"

#ifndef _WIN32
pthread_key_t jffi_threadDataKey;
static void thread_data_free(void *ptr);
#endif

static jfieldID LongRef_Value; /* id for field 'value'  */
static jfieldID IntRef_Value; /* id for field 'value'  */

JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM *jvm, void *reserved)
{
    	JNIEnv *env;
	if ((*jvm)->GetEnv(jvm, (void **) &env, JNI_VERSION_1_2)) {
		return JNI_ERR;
	}

#ifndef _WIN32
    struct sigaction sa;
    pthread_key_create(&jffi_threadDataKey, thread_data_free);

#if FAULT_PROTECT_ENABLED
    memset(&sa, 0, sizeof(sa));
    sa.sa_sigaction = jffi_sigsegv;
    sa.sa_flags = SA_SIGINFO;
    sigaction(SIGSEGV, &sa, &jffi_sigsegv_chain);
    sa.sa_sigaction = jffi_sigbus;
    sigaction(SIGBUS, &sa, &jffi_sigbus_chain);
#endif

#endif
    
    	//Get field IDs
	jclass LongRef = (*env)->FindClass(env, "com/kenai/jffi/LongRef");
	if (LongRef == NULL) {
		return JNI_ERR;
	}

	LongRef_Value = (*env)->GetFieldID(env, LongRef, "value", "J");
	if (LongRef_Value == NULL) {
		return JNI_ERR;
	}
      	(*env)->DeleteLocalRef(env, LongRef);
        
	jclass IntRef = (*env)->FindClass(env, "com/kenai/jffi/IntRef");
	if (IntRef == NULL) {
		return JNI_ERR;
	}

	IntRef_Value = (*env)->GetFieldID(env, IntRef, "value", "I");
	if (IntRef_Value == NULL) {
		return JNI_ERR;
	}
        
      	(*env)->DeleteLocalRef(env, IntRef);


    return JNI_VERSION_1_4;
}

JNIEXPORT void JNICALL 
JNI_OnUnload(JavaVM *jvm, void *reserved)
{
#ifndef _WIN32
    pthread_key_delete(jffi_threadDataKey);
#endif
}

#ifndef _WIN32
ThreadData*
jffi_thread_data_init()
{
    ThreadData* td = calloc(1, sizeof(*td));
    pthread_setspecific(jffi_threadDataKey, td);
    return td;
}

static void
thread_data_free(void *ptr)
{
    ThreadData* td = (ThreadData *) ptr;
    
    if (td->attached_vm != NULL) {
        (*td->attached_vm)->DetachCurrentThread(td->attached_vm);
    }

    free(ptr);
}
#endif /* !_WIN32 */

/*
 * Class:     com_kenai_jffi_Foreign
 * Method:    init
 * Signature: ()V
 *
 * Initialize any class/method/field ids
 */

JNIEXPORT void JNICALL
Java_com_kenai_jffi_Foreign_init(JNIEnv* env, jobject self)
{
    
}

JNIEXPORT jint JNICALL
Java_com_kenai_jffi_Foreign_getJNIVersion(JNIEnv* env, jobject self)
{
    return (*env)->GetVersion(env);
}

JNIEXPORT jlong JNICALL
Java_com_kenai_jffi_Foreign_getJavaVM(JNIEnv *env, jobject self)
{
    JavaVM* vm;
    (*env)->GetJavaVM(env, &vm);
    return p2j(vm);
}

JNIEXPORT void JNICALL
Java_com_kenai_jffi_Foreign_fatalError(JNIEnv * env, jobject self, jstring msg)
{
    const char* str = (*env)->GetStringUTFChars(env, msg, NULL);
    (*env)->FatalError(env, str);
    (*env)->ReleaseStringUTFChars(env, msg, str);
}

JNIEXPORT jclass JNICALL
Java_com_kenai_jffi_Foreign_defineClass__Ljava_lang_String_2Ljava_lang_Object_2_3BII(JNIEnv *env,
        jobject self, jstring jname, jobject loader, jbyteArray jbuf, jint off, jint len)
{
    const char* name = NULL;
    jbyte* buf = NULL;
    jclass retval = NULL;

    name = (*env)->GetStringUTFChars(env, jname, NULL);
    if (name == NULL) {
        throwException(env, NullPointer, "Invalid name parameter");
        goto cleanup;
    }
    buf = (*env)->GetByteArrayElements(env, jbuf, NULL);
    if (buf == NULL) {
        throwException(env, NullPointer, "Invalid buffer parameter");
        goto cleanup;
    }

    retval = (*env)->DefineClass(env, name, loader, buf + off, len);

cleanup:
    if (buf != NULL) {
        (*env)->ReleaseByteArrayElements(env, jbuf, buf, JNI_ABORT);
    }
    if (name != NULL) {
        (*env)->ReleaseStringUTFChars(env, jname, name);
    }

    return retval;
}

JNIEXPORT jclass JNICALL
Java_com_kenai_jffi_Foreign_defineClass__Ljava_lang_String_2Ljava_lang_Object_2Ljava_nio_ByteBuffer_2(JNIEnv *env,
        jobject self, jstring jname, jobject loader, jobject jbuf)
{
    const char* name = NULL;
    jclass retval = NULL;

    name = (*env)->GetStringUTFChars(env, jname, NULL);
    if (name == NULL) {
        throwException(env, NullPointer, "Invalid name parameter");
        goto cleanup;
    }

    if (jbuf == NULL) {
        throwException(env, NullPointer, "Invalid buffer parameter");
        goto cleanup;
    }

    retval = (*env)->DefineClass(env, name, loader,
            (*env)->GetDirectBufferAddress(env, jbuf),
            (*env)->GetDirectBufferCapacity(env, jbuf));

cleanup:
    if (name != NULL) {
        (*env)->ReleaseStringUTFChars(env, jname, name);
    }

    return retval;
}

JNIEXPORT jobject JNICALL
Java_com_kenai_jffi_Foreign_allocObject(JNIEnv *env, jobject self, jclass klass)
{
    return (*env)->AllocObject(env, klass);
}

JNIEXPORT jint JNICALL
Java_com_kenai_jffi_Foreign_registerNatives(JNIEnv *env, jobject self, jclass clazz,
        jlong methods, jint nmethods)
{
    return (*env)->RegisterNatives(env, clazz, j2p(methods), nmethods);
}

JNIEXPORT jint JNICALL
Java_com_kenai_jffi_Foreign_unregisterNatives(JNIEnv *env, jobject self, jclass clazz)
{
    return (*env)->UnregisterNatives(env, clazz);
}

/*
 * Determine the cpu type at compile time - useful for MacOSX where the jvm
 * reports os.arch as 'universal'
 */
#if defined(__i386__) || defined(__i386)
# define CPU "i386"

#elif defined(__x86_64__) || defined(__x86_64) || defined(__amd64)
# define CPU "x86_64"

#elif defined(__ppc64__) || defined(__powerpc64__)
# if BYTE_ORDER == LITTLE_ENDIAN
#  define CPU "ppc64le"
# else
#  define CPU "ppc64"
# endif

#elif defined(__ppc__) || defined(__powerpc__) || defined(__powerpc)
// Need to check if ppc is still 64-bit, as gcc doesn't necessarily define the
// 64-bit variables
#include <stdint.h>
# if INTPTR_MAX == INT64_MAX
#  if BYTE_ORDER == LITTLE_ENDIAN
#   define CPU "ppc64le"
#  else
#   define CPU "ppc64"
#  endif
# else
#  define CPU "ppc"
# endif

/*
 * Need to check for __sparcv9 first, because __sparc will be defined either way.
 * Note that __sparcv9 seems to only be set for Solaris. On Linux, __sparc will
 * be set, along with __arch64__ if a 64-bit platform.
 */
#elif defined(__sparcv9__) || defined(__sparcv9)
# define CPU "sparcv9"

#elif defined(__sparc__) || defined(__sparc)
# if defined(__arch64__)
#  define CPU "sparcv9"
# else
#  define CPU "sparc"
# endif

#elif defined(__arm__) || defined(__arm)
# define CPU "arm"

#elif defined(__ia64__) || defined(__ia64)
# define CPU "ia64"

#elif defined(__mips__) || defined(__mips)
# define CPU "mips"

#elif defined(__s390__)
# define CPU "s390"

#else
# define CPU "unknown"
#endif

/*
 * Class:     com_kenai_jffi_Foreign
 * Method:    getArch
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL 
Java_com_kenai_jffi_Foreign_getArch(JNIEnv *env, jobject self)
{
    return (*env)->NewStringUTF(env, CPU);
}

JNIEXPORT jboolean JNICALL 
Java_com_kenai_jffi_Foreign_isFaultProtectionEnabled(JNIEnv *env , jclass klass)
{
    return FAULT_PROTECT_ENABLED ? JNI_TRUE : JNI_FALSE; 
}

JNIEXPORT jlong JNICALL
Java_com_kenai_jffi_Foreign_ret_1LONGLONG_1_1LONGLONG_1LONGLONG(JNIEnv* env, jclass clazz, jlong function, jlong arg1, jlong arg2) \
{ 
    return (jlong)((long long (*)(long long, long long)) (function))(((long long)arg1), ((long long)arg2)); 
}

JNIEXPORT jlong JNICALL
Java_com_kenai_jffi_Foreign_ret_1LONG_1_1LONG_1LONG(JNIEnv* env, jclass clazz, jlong function, jlong arg1, jlong arg2) \
{ 
    return (jlong)((long (*)(long, long)) (function))(((long)arg1), ((long)arg2)) & 0xFFFFFFFF; 
}

JNIEXPORT jint JNICALL
Java_com_kenai_jffi_Foreign_ret_1INTEGER_1_1INTEGER_1INTEGER(JNIEnv* env, jclass clazz, jlong function, jint arg1, jint arg2) \
{ 
    int result = ((int (*)(int, int)) (function))(((int)arg1), ((int)arg2));
	result++;
result--;	
return result; 
}


/*
 * Class:     com_kenai_jffi_Foreign
 * Method:    ret_LONGLONG__LONGLONG_PtrLONGLONG
 * Signature: (JJLcom/kenai/jffi/LongRef;)J
 */
JNIEXPORT jlong JNICALL Java_com_kenai_jffi_Foreign_ret_1LONGLONG_1_1LONGLONG_1PtrLONGLONG
  (JNIEnv *env, jclass clazz, jlong function, jlong arg1, jobject arg2)
{ 
    long long larg2 = (*env)->GetLongField(env, arg2, LongRef_Value);
    jlong result = (jlong)((long long (*)(long long, long long *)) (function))(((long long)arg1), (&larg2)); 
    (*env)->SetLongField(env, arg2, LongRef_Value, larg2);
    return (jlong)result;
}


/*
 * Class:     com_kenai_jffi_Foreign
 * Method:    ret_LONG__LONG_PtrLONG
 * Signature: (JJLcom/kenai/jffi/LongRef;)J
 */
JNIEXPORT jlong JNICALL Java_com_kenai_jffi_Foreign_ret_1LONG_1_1LONG_1PtrLONG
  (JNIEnv *env, jclass clazz, jlong function, jlong arg1, jobject arg2)
{ 
    long larg2 = (*env)->GetLongField(env, arg2, LongRef_Value);
    jlong result = (jlong)((long (*)(long, long *)) (function))(((long)arg1), (&larg2)); 
    (*env)->SetLongField(env, arg2, LongRef_Value, larg2);
    return result;
}


/*
 * Class:     com_kenai_jffi_Foreign
 * Method:    ret_INTEGER__INTEGER_PtrINTEGER
 * Signature: (JILcom/kenai/jffi/IntRef;)I
 */
JNIEXPORT jint JNICALL Java_com_kenai_jffi_Foreign_ret_1INTEGER_1_1INTEGER_1PtrINTEGER
  (JNIEnv *env, jclass clazz, jlong function, jint arg1, jobject arg2)
{ 
    int iarg2 = (*env)->GetIntField(env, arg2, IntRef_Value);
    jint result = (jint)((int (*)(int, int *)) (function))(((int)arg1), (&iarg2));
    (*env)->SetIntField(env, arg2, IntRef_Value, iarg2);
    return result;
}

