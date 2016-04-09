#include<stdio.h>
#include "com_handsomezhou_Calculate_Calculate.h"
/*
 * Class:     com_handsomezhou_Calculate_Calculate
 * Method:    plus
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_handsomezhou_Calculate_Calculate_plus
  (JNIEnv *env, jclass jc, jint x, jint y){
	  return (x+y);
  }

/*
 * Class:     com_handsomezhou_Calculate_Calculate
 * Method:    minus
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_com_handsomezhou_Calculate_Calculate_minus
  (JNIEnv *env, jclass jc, jint x, jint y){
	  return (x-y);
  }