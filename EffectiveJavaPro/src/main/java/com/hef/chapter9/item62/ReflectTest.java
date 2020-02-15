package com.hef.chapter9.item62;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

/**
 * @Date 2020/2/15
 * @Author lifei
 */
public class ReflectTest {

    public static void main(String[] args) {
        String[] array = new String[]{"java.util.HashSet", "aa", "bb"};
        setTest(array);
    }



    private static void setTest(String[] args){
        Class<? extends Set<String>> cl = null;
        try {
            cl = (Class<? extends Set<String>>) Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            fatalError("Class not found.");
        }

        Constructor<? extends Set<String>> cons = null;
        try {
            cons = cl.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fatalError("No parameterless constructor");
        }
        Set<String> s = null;
        try {
            s = cons.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        s.addAll(Arrays.asList(args).subList(1, args.length));
        System.out.println(s);
    }

    private static void fatalError(String msg){
        System.err.println(msg);
        System.exit(1);
    }
}
