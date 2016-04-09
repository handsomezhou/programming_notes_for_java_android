Steps In Using JNI

1. Java code (write and compile)

  *Declare native methods using native and no body.
	public native void nativeOne();
  *Ensure that a shared library, to be created later,is loaded before the native method is called.System.loadLibrary("NativeLib");
	Usually executed in a static initializer block in the class that calls the native method(s)
  
2. Create a C header file containing functionprototypes for the native methods.

	javah -jni NativeMethods
	where NativeMethods is the Java class containing the native methods.

3. Write C implementations of native methods using mangled names and extra parameters.

  Native (C/C++) code function names are formed from the following pieces:
  'Java_' Mangled fully qualified class name with periods becoming underscores '_' Mangled method name
  For overloaded Java methods:
  Continue with two underscores '__' Mangled argument types
  Better: Get prototype from header file created in step 2.
  
  Linux and HP Version
  JNIEXPORT void JNICALL Java_NativeMethods_nativeOne(JNIEnv * env, jobject thisObj)
  
  Note: JNIEXPORT and JNICALL are currently defined to be nothing.

4. Compile C code and Create shared library

	$gcc -I/usr/java/j2sdk1.4.2_05/include
	-I/usr/java/j2sdk1.4.2_05/include/linux
	-shared cImplOne.c cImplTwo.c
	-o libNativeLib.so

	Note that the name of the shared library has the prefix "lib" in front of it.

5. Execute Java program

  $java Main

  

Example:
//Compiler and Runtime Environment:Ubuntu
//1. Java code (write and compile)
$touch Calculate.java
$javac -d ./ Calculate.java 

2. Create a C header file containing functionprototypes for the native methods.
$javah com.handsomezhou.Calculate.Calculate

//3. Write C implementations of native methods using mangled names and extra parameters.
$touch Calculate.c

//4. Compile C code and Create shared library
//note: 
//(1)The machine jdk directory replace "/usr/lib/jvm/java-6-openjdk-i386/include" 
//(2)The name of the shared library has the prefix "lib" in front of it.
$gcc -shared -fpic -o libCalculate.so -I/usr/lib/jvm/java-6-openjdk-i386/include -I/usr/lib/jvm/java-6-openjdk-i386/include/linux Calculate.c

//5. Execute Java program
$java -Djava.library.path=. com.handsomezhou.Calculate.Calculate

Reference

1.https://blogs.oracle.com/moonocean/entry/a_simple_example_of_jni
2.https://segmentfault.com/a/1190000000658143
3.http://homepage.cs.uiowa.edu/~slonnegr/wpj/JNI.pdf
