package com.hef.chapter8.item52;

import java.math.BigInteger;
import java.util.*;

/**
 * @Date 2020/2/11
 * @Author lifei
 */
public class CollectionClassifier {

//    public static String classify(Set<?> s){
//        return "Set";
//    }
//
//    public static String classify(List<?> lst){
//        return "List";
//    }
//
//    public static String classify(Collection<?> lst){
//        return "Unknown Collection";
//    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
          new HashSet<String>(),
          new ArrayList<BigInteger>(),
          new HashMap<String, String>().values()
        };

        for (Collection<?> collection : collections) {
            System.out.println(classify(collection));
        }
    }

    public static String classify(Collection<?> c){
        return c instanceof Set ? "Set" :
                c instanceof List ? "List" : "unknown Collection";
    }
}
