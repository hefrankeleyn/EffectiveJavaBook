package com.hef.chapter6.item34;

import java.util.Optional;

/**
 * @Date 2020/1/29
 * @Author lifei
 */
public class OperationMain {

    public static void main(String[] args) {
        Operation plus = Operation.valueOf("PLUS");
        System.out.println(plus);
        Optional<Operation> plus1 = Operation.fromString("+");
        System.out.println(plus1.get());
    }
}
