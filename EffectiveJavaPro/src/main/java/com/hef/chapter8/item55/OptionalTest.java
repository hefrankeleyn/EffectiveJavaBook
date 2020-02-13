package com.hef.chapter8.item55;

import java.util.Optional;

/**
 * @Date 2020/2/12
 * @Author lifei
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<Object> optionalEmpty = Optional.empty();
        System.out.println(optionalEmpty);
        if (optionalEmpty.isPresent()){
            System.out.println(optionalEmpty.get());
        }

        Optional<String> aa = Optional.of("aa");
        System.out.println(aa.get());

//        Optional<Object> o = Optional.of(null);
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o);
    }
}
