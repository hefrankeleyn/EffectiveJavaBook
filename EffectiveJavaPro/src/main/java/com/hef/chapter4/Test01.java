package com.hef.chapter4;

import java.util.AbstractCollection;
import java.util.HashSet;
import java.util.Set;

/**
 * @Date 2020/1/13
 * @Author lifei
 */
public class Test01 {

    public static void main(String[] args) {
//        AbstractCollection
//        AbstractCollection
        Set<String> set = new HashSet<>();
        System.out.println(set instanceof Set);
        System.out.println(set instanceof Set<?>);
        

    }
}
