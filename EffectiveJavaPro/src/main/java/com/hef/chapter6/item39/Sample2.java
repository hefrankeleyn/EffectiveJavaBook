package com.hef.chapter6.item39;

/**
 * @Date 2020/2/2
 * @Author lifei
 */
public class Sample2 {

    // Test should pass
    @MyExceptionTest(value = ArithmeticException.class)
    public static void m1(){
        int i = 0;
        i = i/i;
    }

    // Should fail (wrong exception)
    @MyExceptionTest(value = ArithmeticException.class)
    public static void m2(){
        int[] a = new int[0];
        int i = a[1];
    }

    // Should fail (no exception)
    @MyExceptionTest(value = ArithmeticException.class)
    public static void m3(){

    }


}
