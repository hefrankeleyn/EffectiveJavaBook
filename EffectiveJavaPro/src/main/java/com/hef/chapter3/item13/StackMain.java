package com.hef.chapter3.item13;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 2020/1/7
 * @Author lifei
 */
public class StackMain {
    public static void main(String[] args) {
        test01();
//        test02();
    }

    private static void test02(){
        Stack stack = new Stack();
        StringBuffer sb = new StringBuffer("first");
        stack.push(sb);
        Stack clone = stack.clone();
        sb = (StringBuffer)stack.pop();
        sb.append(" second");
        stack.push(sb);
        System.out.println("stack pop: " + stack.pop());
        System.out.println("clone pop: " + clone.pop());


    }

    private static void test01(){
        Stack stack = new Stack();
        stack.push("aa");
        stack.push("bb");
        stack.push("cc");
        System.out.println("size: "+stack.size());

        Stack clone = stack.clone();

        System.out.println("size: "+clone.size());
        System.out.println("clone pop:" + clone.pop());
        System.out.println("stack pop:" + stack.pop());
    }

    private static void test03(){
        List<String> iList = new ArrayList<>();
        List<String> list = new ArrayList<>(iList);
    }
}
