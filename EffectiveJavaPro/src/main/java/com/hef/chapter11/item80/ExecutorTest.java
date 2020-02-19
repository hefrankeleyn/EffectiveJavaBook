package com.hef.chapter11.item80;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Date 2020/2/19
 * @Author lifei
 */
public class ExecutorTest {

    public static void main(String[] args) {

    }

    private static void test01(){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Runnable runnable = ()->{
            System.out.println("hello world");
        };
        exec.execute(runnable);
        exec.shutdown();

//        corePoolSize
//        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(23);
    }
}
