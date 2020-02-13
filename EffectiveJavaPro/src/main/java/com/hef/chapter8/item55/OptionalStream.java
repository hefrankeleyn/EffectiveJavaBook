package com.hef.chapter8.item55;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @Date 2020/2/12
 * @Author lifei
 */
public class OptionalStream {

    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        Optional<String> max = max(collection);
        System.out.println(max);
        String maxStr = collection.stream().max(Comparator.naturalOrder()).orElse("default str");
        String s = collection.stream().max(Comparator.naturalOrder()).orElseThrow(RuntimeException::new);
        collection.stream().max(Comparator.naturalOrder()).orElseGet(()->"aa");
        System.out.println(maxStr);
        collection.stream().max(Comparator.naturalOrder());
    }

    public static <E extends Comparable<E>>Optional<E> max(Collection<E> c){
        return c.stream().max(Comparator.naturalOrder());
    }
}
