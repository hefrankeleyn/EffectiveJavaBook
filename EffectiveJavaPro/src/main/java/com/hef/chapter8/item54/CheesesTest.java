package com.hef.chapter8.item54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Date 2020/2/12
 * @Author lifei
 */
public class CheesesTest {

    private final List<Cheese> cheesesInStock = new ArrayList<>();

    // 不要这样做
    @Deprecated
    public List<Cheese> getCheeses(){
        return cheesesInStock.isEmpty()? null: new ArrayList<>(cheesesInStock);
    }

    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
    public Cheese[] getCheesesArray(){
//        return cheesesInStock.toArray(new Cheese[0]);
        return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
    }

    public static void main(String[] args) {

    }

    public void test01(){
        Collections.emptyList();
        Collections.emptySet();
        Collections.emptyMap();

    }
}

class Cheese{

}
