package com.hef.chapter8.item49;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @Date 2020/2/11
 * @Author lifei
 */
public class MethodMain {

    public static void main(String[] args) {
        test01();
    }

    private static void test01(){
        BigInteger m = null;
        Objects.requireNonNull(m).signum();
    }

    private static final Thing[] private_values = {};
    private static final List<Thing> values = Collections.unmodifiableList(Arrays.asList(private_values));

    private static void test02(){

    }

    private class Thing{

    }
}
