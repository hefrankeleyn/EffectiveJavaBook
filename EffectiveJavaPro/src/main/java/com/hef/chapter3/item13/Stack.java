package com.hef.chapter3.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Date 2020/1/7
 * @Author lifei
 */
public class Stack implements Cloneable{
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 3;

    public Stack(){
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY]; // eliminate obsolete reference
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    public int size(){
        return size;
    }

    public Object pop(){
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; //
        return result;
    }

    public void ensureCapacity(){
        if (elements.length == size){
            elements = Arrays.copyOf(elements, 2*size + 1);
        }
    }

    @Override
    public Stack clone()  {
        try {
            Stack result =  (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
