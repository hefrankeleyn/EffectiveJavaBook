package com.hef.chapter7.item47;

import java.util.*;

/**
 * 在二进制数 0 至 $2^n$ 和 有位元素的集合的幂集之间，有一个自然映射
 * @Date 2020/2/10
 * @Author lifei
 */
public class PowerSet {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        Collection<Set<String>> collection = of(set);
        System.out.println(collection.size());
        for (Set<String> strings : collection) {
            System.out.println(strings);
        }
    }

    public static final <E>Collection<Set<E>> of(Set<E> s){
        List<E> src = new ArrayList<>(s);
        if (src.size()>30){
            throw new IllegalArgumentException("Set too big" +s );
        }
        return new AbstractList<Set<E>>() {
            // 2 to the power srcSize
            // 这个方法限制了 序列的长度位 Integer.MAX_VALUE  或者 2^31-1
            @Override
            public int size() {
                return 1<<src.size();
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set)o);
            }

            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                System.out.println("index : " + index);
                for (int i = 0; index != 0; i++, index >>= 1) {
                    if ((index & 1) == 1) {
                        System.out.println("i = " + i);
                        result.add(src.get(i));
                    }
                }
                return result;
            }
        };
    }
}
