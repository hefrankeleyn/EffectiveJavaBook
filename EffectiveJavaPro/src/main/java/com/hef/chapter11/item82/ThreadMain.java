package com.hef.chapter11.item82;

import java.util.Collections;

/**
 * @Date 2020/2/23
 * @Author lifei
 */
public class ThreadMain {

    public static void main(String[] args) {

    }

    private static void synchronizedTest01(){
//        Collections.synchronizedCollection()
    }

    // Normal initialization of an instance field
//    private final FieldType field = computeFieldValue();

    private FieldType computeFieldValue(){
        return new FieldType();
    }

    // lazy initialization of instance field - synchronized accessor
    private FieldType field;
    private synchronized FieldType getField(){
        if (field == null)
            field = computeFieldValue();
        return field;
    }
}
