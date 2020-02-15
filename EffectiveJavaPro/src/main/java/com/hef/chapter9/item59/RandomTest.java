package com.hef.chapter9.item59;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Date 2020/2/14
 * @Author lifei
 */
public class RandomTest {

    public static void main(String[] args) {
//        randomTest();
        threadLocalRandomTest();
    }

    private static void randomTest(){
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int r = random.nextInt(23);
            System.out.println("r : " + r);
        }
    }

    private static void threadLocalRandomTest(){
        ThreadLocalRandom current = ThreadLocalRandom.current();
        for (int i = 0; i < 20; i++) {
            int r = current.nextInt(23);
            System.out.println("r: " + r);
        }

    }
}
