package com.hef.chapter7.item47;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Date 2020/2/10
 * @Author lifei
 */
public class SubLists {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("cc");
        list.add("bb");
//        list.add("dd");
//        list.add("ee");

        for (List<String> list1: iterableOf(prefixes(list))){
            System.out.println(list1);
        }

        for (List<String> list2 : iterableOf(suffixes(list))) {
            System.out.println(list2);
        }

        System.out.println("*************");
        // 前缀的后缀 + 空集合
        for (List<String> strings : iterableOf(of(list))) {
            System.out.println(strings);
        }


        System.out.println("*************");
        for (List<String> strings : iterableOf(of03(list))) {
            System.out.println(strings);
        }

    }

    public static <E> Stream<List<E>> of02(List<E> list){
        return IntStream.range(0, list.size())
                .mapToObj(start -> IntStream.rangeClosed(start + (int)Math.signum(start), list.size()).mapToObj(end -> list.subList(start, end)))
                .flatMap(x->x);
    }

    public static <E> Stream<List<E>> of03(List<E> list){
        return Stream.concat(Stream.of(Collections.emptyList()), IntStream.range(0, list.size())
                .mapToObj(start-> IntStream.rangeClosed(start + 1, list.size()).mapToObj(end -> list.subList(start, end)))
                .flatMap(x->x));
    }

    /**
     * 获取元素的幂集
     *   flatMap 生成一个包含了所有前缀的所有后缀的Stream
     * @param list
     * @param <E>
     * @return
     */
    public static <E> Stream<List<E>> of(List<E> list){
        return Stream.concat(Stream.of(Collections.emptyList()), prefixes(list)
                .flatMap(SubLists::suffixes));
    }
    /**
     * 列表的前缀
     * @param list
     * @param <E>
     * @return
     */
    private static <E> Stream<List<E>> prefixes(List<E> list){
        return IntStream.rangeClosed(1, list.size()).mapToObj(end->list.subList(0, end));
    }

    /**
     * 列表的后缀
     * @param list
     * @param <E>
     * @return
     */
    private static <E> Stream<List<E>> suffixes(List<E> list){
        return IntStream.range(0, list.size()).mapToObj(start -> list.subList(start, list.size()));
    }

    private static <E> Iterable<E> iterableOf(Stream<E> stream){
        return stream::iterator;
    }
}
