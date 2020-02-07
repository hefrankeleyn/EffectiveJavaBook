package com.hef.chapter2.item8;

/**
 * @Date 2020/1/2
 * @Author lifei
 */
public class Adult {

    public static void main(String[] args) {
        try(Room room = new Room(7)){
            System.out.println("Goodbye");
        }
    }
}
