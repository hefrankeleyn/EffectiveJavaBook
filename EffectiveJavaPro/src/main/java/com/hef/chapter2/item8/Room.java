package com.hef.chapter2.item8;

import java.lang.ref.Cleaner;

/**
 * @Date 2020/1/2
 * @Author lifei
 */
public class Room implements AutoCloseable{

    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable{

        int numJunkPiles;
        State(int numJunkPiles){
            this.numJunkPiles = numJunkPiles;
        }


        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    private final State state;
    private final Cleaner.Cleanable cleanable;
    public Room(int numJunkPiles){
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close(){
        cleanable.clean();
    }
}
