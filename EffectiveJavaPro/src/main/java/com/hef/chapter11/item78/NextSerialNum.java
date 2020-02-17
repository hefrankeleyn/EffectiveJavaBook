package com.hef.chapter11.item78;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Date 2020/2/16
 * @Author lifei
 */
public class NextSerialNum {

    // Broken - require synchronization!
    private static volatile int nextSerialNumber = 0;

    public static int generateSerialNumber(){
        return nextSerialNumber++;
    }

    private static final AtomicLong nextSerialNumberAtomic = new AtomicLong();

    public static long generateSerialNumberAtomic(){
        return nextSerialNumberAtomic.getAndIncrement();
    }
}
