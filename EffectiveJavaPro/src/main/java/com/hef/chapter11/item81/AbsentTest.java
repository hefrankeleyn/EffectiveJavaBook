package com.hef.chapter11.item81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @Date 2020/2/19
 * @Author lifei
 */
public class AbsentTest {

    public static void main(String[] args) {
//        strInternTest();

        String str2 = new String("str")+new String("01");
        String str1 = "str01";
        str2.intern();
        System.out.println(str1 == str2);

        /*final String a = "hel";
        final String b = "lo";
        // 在编译时，直接替换成了String c=”hel”+”lo”
        String c = a+b;
        System.out.println(c=="hello");*/
    }


    private static void strInternTest(){
        String str = "aa";
        str = "null";
        String intern = str.intern();
        System.out.println(intern);
        StringBuilder sb = new StringBuilder();

    }

    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    private static String intern(String s){
        String result = map.get(s);
        if (result == null){
            result = map.putIfAbsent(s, s);
            if (result == null){
                result = s;
            }
        }
        return result;
    }
}
