package com.hef.chapter6.item39;

/**
 * @Date 2020/2/2
 * @Author lifei
 */
public class Sample3 {

    @MyException2Test(IndexOutOfBoundsException.class)
    @MyException2Test(NullPointerException.class)
    public static void doubleBad(){
        int[] a = new int[0];
        int i = a[0];
    }
}
