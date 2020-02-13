package com.hef.chapter8.item52;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date 2020/2/12
 * @Author lifei
 */
public class LamdbaTest {

    public static void main(String[] args) {
        // 可以正常编译
        new Thread(System.out::println).start();

        ExecutorService exec = Executors.newCachedThreadPool();
        // 无法编译
//        exec.submit(System.out::println);
    }

}
