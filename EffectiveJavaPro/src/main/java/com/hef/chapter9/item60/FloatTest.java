package com.hef.chapter9.item60;

import java.math.BigDecimal;

/**
 * @Date 2020/2/14
 * @Author lifei
 */
public class FloatTest {

    public static void main(String[] args) {
//        floatTest01();
//        payCan();
        payCanDeciaml();
    }

    private static void floatTest01(){
        System.out.println(1.03-0.42);
        System.out.println(1.00-9*0.10);
    }

    private static void payCan(){
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10){
            funds -= price;
            itemsBought ++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + funds);
    }

    private static void payCanDeciaml(){
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought = 0;
        BigDecimal founds = new BigDecimal("1.00");
        for (BigDecimal price  = TEN_CENTS; founds.compareTo(price)>=0; price = price.add(TEN_CENTS)){
            founds = founds.subtract(price);
            itemsBought ++;
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Maney left over: $ " + founds);
    }
}
