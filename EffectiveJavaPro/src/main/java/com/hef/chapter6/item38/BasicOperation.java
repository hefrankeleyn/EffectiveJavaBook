package com.hef.chapter6.item38;

/**
 * @Date 2020/2/2
 * @Author lifei
 */
public enum BasicOperation implements Operation{

    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x+y;
        }
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

    BasicOperation(String symbol){
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return this.symbol;
    }
}
