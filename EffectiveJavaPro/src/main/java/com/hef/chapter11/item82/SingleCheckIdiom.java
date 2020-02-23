package com.hef.chapter11.item82;

/**
 * @Date 2020/2/23
 * @Author lifei
 */
public class SingleCheckIdiom {

    // Single-check idiom - can cause repeated initialization
    private volatile FieldType field;

    private FieldType getField(){
        FieldType result = field;
        if (result == null){
            field = result = computeFieldValue();
        }
        return result;
    }

    private FieldType computeFieldValue(){
        return new FieldType();
    }
}
