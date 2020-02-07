package com.hef.chapter5.item33;

import jdk.jfr.AnnotationElement;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Date 2020/1/28
 * @Author lifei
 */
public class Favorites {

    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance){
//        favorites.put(Objects.requireNonNull(type), instance);
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }


    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);


        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());

    }
}
