package com.hef.chapter11.item81;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date 2020/2/19
 * @Author lifei
 */
public class TimeMain {

    public static void main(String[] args) {
        Runnable runnable = ()->{
            long start = System.nanoTime();
            int i=0;
            while (System.nanoTime() - start <2*1000){
                i++;
            }
            System.out.println("i: " + i);
        };
        ExecutorService exec = Executors.newFixedThreadPool(5);
        try {
            long time = time(exec, 5, runnable);
            System.out.println("time: " + time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exec.shutdown();
    }

    /**
     *
     * @param executor 执行该动作的executor
     * @param concurrency 并发级别
     * @param action  并发执行的动作
     * @return
     */
    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        // 倒计时锁存器：这个int参数是指允许所有在等待的线程被处理之前，必须在锁存器上调用countDown方法的次数
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i=0; i< concurrency; i++){
            final int temp = i;
            executor.execute(()->{
                System.out.println("begin: " + temp);
                ready.countDown();
                try {
                    start.await();
                    System.out.println("end: " + temp);
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }finally {
                    done.countDown();
                }
            });
        }

        ready.await();
        long statNanos = System.nanoTime();
        start.countDown();
        done.await();
        return System.nanoTime() - statNanos;
    }
}
