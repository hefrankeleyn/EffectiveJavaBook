package com.hef.chapter6.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Date 2020/2/2
 * @Author lifei
 */
public class RunMyExceptionTests {

    public static void main(String[] args) throws ClassNotFoundException {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName("com.hef.chapter6.item39.Sample2");
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(MyExceptionTest.class)){
                tests++;
                try {
                    m.invoke(null);
                    System.err.printf("Test %s failed: no exception%n", m);
                } catch (InvocationTargetException wrappedEx) {
                    // 获取实际的异常
                    Throwable cause = wrappedEx.getCause();
                    int oldPassed = passed;
                    // 获取注解上的异常类型
                    Class<? extends Throwable>[] excTypes = m.getAnnotation(MyExceptionTest.class).value();
                    for (Class<? extends Throwable>  excType: excTypes) {
                        if (excType.isInstance(cause)){
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed){
                        System.err.printf("Test %s failed: %s %n", m, cause);
                    }
                } catch (Exception e){
                    System.err.printf("Invalid %s @MyExceptionTest" , m);
                }
            }
        }

        System.out.printf("Passed: %d, Failed: %d%n", passed, tests-passed);
    }
}
