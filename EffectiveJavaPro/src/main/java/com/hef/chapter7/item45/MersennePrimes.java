package com.hef.chapter7.item45;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.*;
/**
 * @Date 2020/2/5
 * @Author lifei
 */
public class MersennePrimes {

    public static void main(String[] args) {
        primes().map(p-> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mp->System.out.println(mp.bitLength() + " : " + mp));
//                .forEach(System.out::println);
    }

    private static Stream<BigInteger> primes(){
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
}
