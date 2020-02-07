package com.hef.chapter7.item42;

import java.util.*;

/**
 * @Date 2020/2/3
 * @Author lifei
 */
public class CompareTest {

    public static void main(String[] args) {
        comparingTest01();
    }

    public static void comparingTest01(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("ddd");
        list.add("cc");
        list.add("eeeeee");
        list.add("bbbbb");

        System.out.println(list.toString());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        // 方案一：
        Collections.sort(list, (s1,s2)->Integer.compare(s1.length(), s2.length()));
        // 方案二：
        Collections.sort(list, Comparator.comparingInt(String::length));
        // 方案三：
        list.sort(Comparator.comparingInt(String::length));
        System.out.println(list.toString());

    }
}
