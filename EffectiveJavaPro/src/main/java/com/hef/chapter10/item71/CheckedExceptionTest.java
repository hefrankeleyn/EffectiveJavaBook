package com.hef.chapter10.item71;

import java.util.AbstractSequentialList;
import java.util.ConcurrentModificationException;
import java.util.concurrent.Executors;

/**
 * @Date 2020/2/16
 * @Author lifei
 */
public class CheckedExceptionTest {

    public static void main(String[] args) {

    }

    private static void handleCheckedExceptionTest01() {

        /*try {

        }catch (TheCheckedException e){
            throw new AssertionError();// Can't happen!
        }*/
    }

    private static void handleCheckedExceptionTest02(){
        /*try {

        }catch (TheCheckedException e){
            e.printStackTrace();  // Oh well, we lose
            System.exit(1);
        }*/
    }

    private static void checkedTest03(){
        /*try {
            obj.action(args);
        }catch (TheCheckedException e){
            ... // Handle exceptional condition
        }*/
    }

    private static void checkedTest04(){
        /*if (obj.actionPermitted(args)){
            obj.action(args);
        }else {
            ... // handle exception condition
        }*/
    }

    private static void sortException(){
//        NumberFormatException
    }

    private static void exceptionTranslation(){
//        AbstractSequentialList
        /*try {

        }catch (LowerLevelException e){
            throw new HigherLevelException(...);
        }*/
    }

    private static void exceptionChaining(){
        /*try{

        }catch (LowerLevelException cause){
            throw new HigherLevelException(cause);
        }*/
    }

    // Exception with chaining-aware constructor
    class HigherLevelException extends Exception{
        HigherLevelException(Throwable cause){
            super(cause);
        }
    }

    private static void catchTest(){
//        IndexOutOfBoundsException
    }




}
