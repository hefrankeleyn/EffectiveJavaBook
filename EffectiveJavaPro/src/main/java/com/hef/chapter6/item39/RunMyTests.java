package com.hef.chapter6.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date 2020/2/2
 * @Author lifei
 */
public class RunMyTests {

    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.hef.chapter6.item39.Sample");
        for (Method m : testClass.getDeclaredMethods()) {
            // isAnnotationPresent 告知要运行哪些方法
            if (m.isAnnotationPresent(MyTest.class)){
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable cause = wrappedExc.getCause();
                    System.err.println(m + " failed: " + cause);
                } catch (Exception e){
                    System.out.println("Invalid @MyTest: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests-passed);
    }
}
