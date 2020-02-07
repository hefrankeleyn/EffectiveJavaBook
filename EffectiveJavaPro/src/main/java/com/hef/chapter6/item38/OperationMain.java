package com.hef.chapter6.item38;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Date 2020/2/2
 * @Author lifei
 */
public class OperationMain {

    public static void main(String[] args) {
        double x = 23;
        double y = 15;
        test(BasicOperation.class, x, y);
        //test(ExtendedOperation.class, x, y);
        test(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y){
        for (Operation operation : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
        }
    }

    private static void test(Collection<? extends Operation> opSet, double x, double y){
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
