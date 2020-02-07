package com.hef.chapter5.item26;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/1/16
 * @Author lifei
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0);

//        unsafeAddObj(strings, Integer.valueOf(32));
    }

    private static void unsafeAdd(List list, Object o){
        list.add(o);
    }

    private static void unsafeAddObj(List<Object> list, Object o){
        list.add(o);
    }
}
