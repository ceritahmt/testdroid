/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_zhongyi_gpiodemo_MainActivity */

#ifndef _Included_com_zhongyi_gpiolibrary_GpioManager
#define _Included_com_zhongyi_gpiolibrary_GpioManager
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_example_beep_GpioCtr
 * Method:    exportGpio
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_zhongyi_gpiolibrary_GpioManager_exportGpio
        (JNIEnv *, jclass, jint);

/*
 * Class:     com_example_beep_GpioCtr
 * Method:    setGpioDirection
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_zhongyi_gpiolibrary_GpioManager_setGpioDirection
        (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_example_beep_GpioCtr
 * Method:    readGpioStatus
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_zhongyi_gpiolibrary_GpioManager_readGpioStatus
        (JNIEnv *, jclass, jint);

/*
 * Class:     com_example_beep_GpioCtr
 * Method:    writeGpioStatus
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_zhongyi_gpiolibrary_GpioManager_writeGpioStatus
        (JNIEnv *, jclass, jint, jint);

/*
 * Class:     com_example_beep_GpioCtr
 * Method:    unexportGpio
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_zhongyi_gpiolibrary_GpioManager_unexportGpio
        (JNIEnv *, jclass, jint);

#ifdef __cplusplus
}
#endif
#endif
