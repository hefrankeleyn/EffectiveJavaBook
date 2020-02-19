package com.hef.chapter11.item79;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Date 2020/2/17
 * @Author lifei
 */
public class ClientMain {

    public static void main(String[] args) {
//        client01();
        client02();
//        iterateDeleteTest();
//        client03();
    }

    private static void client01(){
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver((s, e)-> System.out.println(e));

        for (int i=0; i<100; i++){
            set.add(i);
        }
    }

    // 因为函数对象需要将自身传给 s.removeObserver, 而 lambda 则无法访问自己
    private static void client02(){
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> s, Integer element) {
                System.out.println(element);
                if (element==23){
                    s.removeObserver(this);
                }
            }
        });

        for (int i=0; i<100; i++){
            set.add(i);
        }
    }

    private static void client03(){
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        set.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(ObservableSet<Integer> set, Integer element) {
                System.out.println(element);
                if (element == 23){
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    try {
                        executor.submit(()->set.removeObserver(this)).get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new AssertionError(e);
                    } finally {
                        executor.shutdown();
                    }
                }
            }
        });


        for (int i=0; i<100; i++){
            set.add(i);
        }
    }

    private static void iterateDeleteTest(){
        Set<Integer> ia = new HashSet<>();
        ia.add(2);
        ia.add(3);
        ia.add(5);
        for (Integer i: ia){
            if (i==3){
                ia.remove(i);
            }
        }
    }
}
