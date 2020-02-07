package com.hef.chapter5.item30;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Date 2020/1/18
 * @Author lifei
 */
public class UnionTest {

    private <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2){
        return null;
    }

    public static void main(String[] args) {
        dangerous(new ArrayList<>());
    }

    @SafeVarargs
    public static void dangerous(List<String> ... stringList){
        List<Integer> intList = List.of(42);
        Object[] objects = stringList;
        objects[0] = intList;
        String s = stringList[0].get(0);
    }

    public static <T> T[] pickTwo(T a, T b, T c){
        switch (ThreadLocalRandom.current().nextInt(3)){
//            case 0 : return
        }
        return null;
    }

    public void test01(){
    }
}
