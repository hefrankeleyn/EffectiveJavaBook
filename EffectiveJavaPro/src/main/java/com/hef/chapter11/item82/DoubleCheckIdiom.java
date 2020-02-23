package com.hef.chapter11.item82;

/**
 * @Date 2020/2/23
 * @Author lifei
 */
public class DoubleCheckIdiom {

    // Double-check idiom for lazy initialization of instance fields
    private volatile FieldType field;
    private FieldType getField(){
        FieldType result = field;
        if (result==null){
            synchronized (this){
                if (field==null){
                    field = result = computeFieldValue();
                }
            }
        }
        return result;
    }

    private FieldType computeFieldValue(){
        return new FieldType();
    }
}
