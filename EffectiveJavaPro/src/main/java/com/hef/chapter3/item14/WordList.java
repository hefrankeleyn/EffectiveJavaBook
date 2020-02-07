package com.hef.chapter3.item14;

import java.util.*;

import static java.util.Comparator.comparingInt;
/**
 * @Date 2020/1/8
 * @Author lifei
 */
public class WordList {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<>();
        Collections.addAll(s, args);
        int compare = Integer.compare(2, 3);
        System.out.println("Integer compare: " + compare);
        String[] sa = new String[5];
        Arrays.sort(sa,(a,b)->{ return a.compareToIgnoreCase(b);});
        Arrays.sort(sa, String::compareToIgnoreCase);

        System.out.println(s);
    }
}
