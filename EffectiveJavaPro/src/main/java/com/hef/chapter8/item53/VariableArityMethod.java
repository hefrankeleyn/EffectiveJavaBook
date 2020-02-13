package com.hef.chapter8.item53;

/**
 * @Date 2020/2/12
 * @Author lifei
 */
public class VariableArityMethod {

    public static void main(String[] args) {

    }

    public static int min(int firstArg, int... remainingArgs){
        int min = firstArg;
        for (int arg: remainingArgs){
            if (arg< min){
                min = arg;
            }
        }
        return min;
    }

    public static int min(int... args){
        if (args.length==0){
            throw new IllegalArgumentException("Too few arguments");
        }
        int min = args[0];
        for (int i=1; i<args.length;i++){
            if (args[i]<min){
                min = args[i];
            }
        }
        return min;
    }


    public void foo(){}
    public void foo(int a1){}
    public void foo(int a1, int a2){}
    public void foo(int a1, int a2, int a3){}
    public void foo(int a1, int a2, int a3,int... rest){}
}
