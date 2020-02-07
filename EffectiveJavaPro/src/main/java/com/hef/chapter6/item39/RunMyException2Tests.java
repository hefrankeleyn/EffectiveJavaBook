package com.hef.chapter6.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date 2020/2/2
 * @Author lifei
 */
public class RunMyException2Tests {

    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.hef.chapter6.item39.Sample3");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(MyException2Test.class)
                    || m.isAnnotationPresent(MyException2TestContainer.class)){
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Test %s failed: no exception%n", m);
                } catch (Throwable e) {
                    Throwable cause = e.getCause();
                    int oldPassed = passed;
                    MyException2Test[] excTests = m.getAnnotationsByType(MyException2Test.class);
                    for (MyException2Test excTest : excTests) {
                        if (excTest.value().isInstance(cause)){
                            passed++;
                            break;
                        }
                    }
                    if (oldPassed==passed){
                        System.out.printf("Test %s failed: %s %n",m, cause);
                    }
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests-passed);
    }
}
