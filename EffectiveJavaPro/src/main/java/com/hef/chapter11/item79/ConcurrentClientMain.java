package com.hef.chapter11.item79;

import java.util.HashSet;

/**
 * @Date 2020/2/18
 * @Author lifei
 */
public class ConcurrentClientMain {

    public static void main(String[] args) {
        client02();
    }


    private static void client02(){
        ConcurrentObservableSet<Integer> set = new ConcurrentObservableSet<>(new HashSet<>());
        set.addObserver(new ConcurrentSetObserver<Integer>() {
            @Override
            public void added(ConcurrentObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if (element == 23){
                    set.removeObserver(this);
                }
            }
        });

        for (int i=0; i<100; i++){
            set.add(i);
        }
    }
}
