package com.jni.samples;
/**
 * 简单的输出：androidmroefunctiondemo Hello from JNI !
 * @author xuqingfeng
 * 其中Android.mk 和hello-jni.c文件是从NDK文件夹下面的samples拷贝过来的
 *
 */
public class HelloJniTest {
	static {
		System.loadLibrary("hello-jni");
	}
    public native static String stringFromJNI();
    public native static void stringtoJNI(String stt);
    /**
     * 获取密码
     * @return
     */
	static public String getPassFromJNI() {
		return stringFromJNI();
	}
	 /**
     * 获取密码
     * @return
     */
	static public void getPasstoJNI() {
		 stringtoJNI("dddd");
	}
}
