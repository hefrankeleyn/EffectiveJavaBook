package com.hef.chapter5.item26;

import java.util.Arrays;

/**
 * @Date 2020/1/16
 * @Author lifei
 */
public class ArrayTest {

    public static void main(String[] args) {
        int size = 3;
        String[] strings = new String[]{"aa","bb", "cc","dd", "ee"};
        String[] strings1 = Arrays.copyOf(strings, size, strings.getClass());
        printArray(strings);
        printArray(strings1);
        String[] strings2 = new String[size];
        System.arraycopy(strings,0, strings2, 0, size);
        printArray(strings2);
    }

    private static void printArray(String[] strings){
        for (int i = 0; i < strings.length; i++) {
            if (i==strings.length-1) System.out.println(strings[i]);
            else System.out.print(strings[i]+",");
        }
    }
}
