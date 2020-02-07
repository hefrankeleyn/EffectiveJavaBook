package com.hef.chapter6.item34;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operation {

    PLUS("+"){
        public double apply(double x, double y) { return x+y; }
    },
    MINUS("-"){
        @Override
        public double apply(double x, double y) {
            return x-y;
        }
    },
    TIMES("*"){
        @Override
        public double apply(double x, double y) {
            return x*y;
        }
    },
    DIVIDE("/"){
        @Override
        public double apply(double x, double y) {
            return x/y;
        }
    };

    private final String symbol;
    Operation(String symbol){
        this.symbol  = symbol;
    }

    public abstract double apply(double x, double y);

    @Override
    public String toString() {
        return this.symbol;
    }

    private static final Map<String, Operation> stringToEnum = Stream.of(values()).collect(Collectors.toMap(Object::toString, e->e));

    /**
     * 如果在枚举类型中覆盖toString，要考虑编写一个FromString方法，将定制的字符串表示法变回相应的枚举
     * @param symbol
     * @return
     */
    public static Optional<Operation> fromString(String symbol){
        System.out.println(stringToEnum.keySet());
        return Optional.ofNullable(stringToEnum.get(symbol));
    }
}
