package com.hef.chapter8.item52;

import java.util.List;

/**
 * @Date 2020/2/12
 * @Author lifei
 */
public class Overriding {

    public static void main(String[] args) {
        List<Wine> wineList = List.of(
                new Wine(),new SparklingWine(),new Champagne());
        for (Wine wine : wineList) {
            System.out.println(wine.name());
        }
    }
}

class Wine{
    String name(){return "wine";}
}

class SparklingWine extends Wine{
    @Override
    String name() {
        return "sparkling wine";
    }
}

class Champagne extends  SparklingWine{
    @Override
    String name() {
        return "champagne";
    }
}
