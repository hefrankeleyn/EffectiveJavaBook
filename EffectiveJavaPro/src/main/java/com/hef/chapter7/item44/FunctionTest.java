package com.hef.chapter7.item44;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;

/**
 * @Date 2020/2/4
 * @Author lifei
 */
public class FunctionTest {


    public static void main(String[] args) {
        // unaryOperator
        unaryOperatorTest(String::toLowerCase);
        unaryOperatorTest((str)->str.toLowerCase());
        // binaryOperator
        binaryOperatorTest((t1,t2)->Integer.sum(t1,t2));
        binaryOperatorTest(Integer::sum);
        // predicate
        predicateTest(Collection::isEmpty);
        // function
        functionTest(Integer::parseInt);
        // supplier
        supplierTest(Instant::now);
        // consumer
        consumerTest(System.out::println);
    }
    private static void unaryOperatorTest(UnaryOperator<String> unaryOperator){
        String str = "woRLd";
        String apply = unaryOperator.apply(str);
        System.out.println(apply);
    }

    private static void binaryOperatorTest(BinaryOperator<Integer> binaryOperator){
        Integer i = 23;
        Integer j = 24;
        Integer apply = binaryOperator.apply(i, j);
        System.out.println(apply);
    }

    private static void predicateTest(Predicate<List<String>> predicate){
        List<String> list = new ArrayList<>();
        boolean test = predicate.test(list);
        System.out.println(test);
    }

    private static void functionTest(Function<String, Integer> function){
        String numberStr = "23";
        Integer apply = function.apply(numberStr);
        System.out.println(apply);
    }

    private static void supplierTest(Supplier<Instant> supplier){
        Instant instant = supplier.get();
        System.out.println(instant);
    }

    private static void consumerTest(Consumer<String> consumer){
        String str = "consumer...";
        consumer.accept(str);
    }

    private static void funTest01(){

//        IntUnaryOperator
//        LongUnaryOperator
//        DoubleUnaryOperator


//        IntBinaryOperator
//        LongBinaryOperator
//        DoubleBinaryOperator

//        IntPredicate
//        LongPredicate
//        DoublePredicate
//          LongFunction<int[]>

//        IntToLongFunction
//        IntToDoubleFunction
//        LongToIntFunction
//        LongToDoubleFunction
//        DoubleToIntFunction
//        DoubleToLongFunction
//        ToIntFunction
//        ToLongFunction
//        ToDoubleFunction


//        IntFunction
//        LongFunction
//        DoubleFunction

//        IntSupplier
//        LongSupplier
//        DoubleSupplier

//        IntConsumer
//        LongConsumer
//        DoubleConsumer

//        BiPredicate
//        BiFunction
//        BiConsumer

//        ToIntBiFunction
//        ToDoubleBiFunction
//        ToLongBiFunction

//        ObjIntConsumer
//        ObjLongConsumer
//        ObjDoubleConsumer

//        BooleanSupplier

    }

}
