package com.hef.chapter7.item46;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Date 2020/2/10
 * @Author lifei
 */
public class IteratorStreamTest {

    public static void main(String[] args) {
        iteratorTest01();
    }

    private static void iteratorTest01(){
        String[] strArray = {"aa", "bb", "cc", "dd", "ee"};
        Stream<String> stream =  Stream.of(strArray);
        for (String s : iterableOf(stream)) {
            System.out.println(s);
        }

        long count = streamOf(iterableOf(Stream.of(strArray))).count();
        System.out.println("count: " + count);
    }

    /**
     * 适配器， 将Stream<E> 编程 Iterable<E>
     * @param stream
     * @param <E>
     * @return
     */
    public static <E> Iterable<E> iterableOf(Stream<E> stream){
        return stream::iterator;
    }

    /**
     * 适配器，将 Iterable<E> 变成 Stream<E>
     * @param iterable
     * @param <E>
     * @return
     */
    public static <E> Stream<E> streamOf(Iterable<E> iterable){
        return StreamSupport.stream(iterable.spliterator(), false);
    }

}
