package com.hef.chapter7.item42;

import java.util.function.DoubleBinaryOperator;

/**
 * @Date 2020/2/3
 * @Author lifei
 */
public enum Operation {
    PLUS("+", (x,y)-> x+y),
    MINUS("-", (x,y)->x-y),
    TIMES("*", (x, y)->x*y),
    DIVIDE("/", (x,y)->x/y);

    private final String symbol;
    private final DoubleBinaryOperator op;
    Operation(String symbol, DoubleBinaryOperator op){
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return this.symbol;
    }

    public double apply(double x, double y){
        return op.applyAsDouble(x, y);
    }
}
