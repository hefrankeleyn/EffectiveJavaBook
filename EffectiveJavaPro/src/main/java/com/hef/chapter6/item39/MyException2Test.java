package com.hef.chapter6.item39;

import java.lang.annotation.*;

/**
 * @Date 2020/2/2
 * @Author lifei
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(MyException2TestContainer.class)
public @interface MyException2Test {
    Class<? extends Throwable> value();
}
