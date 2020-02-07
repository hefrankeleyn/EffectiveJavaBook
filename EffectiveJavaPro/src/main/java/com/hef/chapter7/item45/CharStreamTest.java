package com.hef.chapter7.item45;

/**
 * @Date 2020/2/5
 * @Author lifei
 */
public class CharStreamTest {

    public static void main(String[] args) {
        test01();
    }

    private static void test01(){
        "Hello world!".chars().forEach(System.out::print);
        System.out.println();
        "Hello world!".chars().forEach(x->System.out.print((char)x));
        System.out.println();
    }

    private static void test02(){

    }
}
