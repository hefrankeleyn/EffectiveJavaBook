package com.hef.chapter6.item39;

/**
 * @Date 2020/2/2
 * @Author lifei
 */
public class Sample {

    // Test should pass
    @MyTest
    public static void m1(){

    }
    public static void m2(){

    }
    // Test should fail
    @MyTest
    public static void m3(){
        throw new RuntimeException("Boom");
    }

    public static void m4(){}

    @MyTest
    public void m5(){}

    public static void m6(){}

    // Test should fail
    @MyTest
    public static void m7(){
        throw new RuntimeException("Crash");
    }

    public static void m8(){

    }


}
