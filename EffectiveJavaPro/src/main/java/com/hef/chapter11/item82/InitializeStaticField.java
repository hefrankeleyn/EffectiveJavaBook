package com.hef.chapter11.item82;

/**
 * @Date 2020/2/23
 * @Author lifei
 */
public class InitializeStaticField {

    // lazy initialization holder class idiom for static fields
    private static class FieldHolder{
        static final FieldType field = computeFieldValue();
    }

    public static FieldType getField(){
        return FieldHolder.field;
    }

    private static FieldType computeFieldValue(){
        return new FieldType();
    }
}
