package com.hef.chapter10.item76;


import java.util.EmptyStackException;

/**
 * @Date 2020/2/16
 * @Author lifei
 */
public class Stack {

    private int size;
    private Object[] elements = new Object[size];
    public Object pop(){
        if (size==0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }


}
