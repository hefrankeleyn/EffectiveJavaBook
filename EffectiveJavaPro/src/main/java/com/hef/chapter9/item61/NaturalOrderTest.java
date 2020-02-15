package com.hef.chapter9.item61;

import java.util.Comparator;

/**
 * @Date 2020/2/14
 * @Author lifei
 */
public class NaturalOrderTest {

    public static void main(String[] args) {
        compareIntegerTest();
    }

    private static void compareIntegerTest(){
        Comparator<Integer> naturalOrder = (i,j)->(i<j)?-1 : (i == j? 0 : 1);
        // return 1
        int compare = naturalOrder.compare(new Integer(23), new Integer(23));
        System.out.println("compare result: " + compare);
    }

    private static void test01(){

        StringBuilder sb = new StringBuilder(23);
        
    }
}
