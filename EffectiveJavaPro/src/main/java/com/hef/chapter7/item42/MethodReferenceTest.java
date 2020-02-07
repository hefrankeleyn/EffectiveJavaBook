package com.hef.chapter7.item42;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Date 2020/2/3
 * @Author lifei
 */
public class MethodReferenceTest {

    public static void main(String[] args) {
        mapMergeTest();
    }

    private static void mapMergeTest(){
        Map<String, Integer> map = new HashMap<>();

        String[] words = new String[]{"aa", "bb", "aa", "cc"};
        for (String word : words) {
            map.merge(word, 1, (count, incr)->count+incr);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s %s %d%n",entry.getKey()," : ",entry.getValue());
        }
    }

}
