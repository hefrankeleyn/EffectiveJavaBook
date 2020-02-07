package com.hef.chapter6.item34;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Date 2020/1/28
 * @Author lifei
 */
public class EnumMain {

    public static void main(String[] args) {
        Apple[] values = Apple.values();

        for (Apple apple: values){
            System.out.println(apple.ordinal());
        }

    }

}
