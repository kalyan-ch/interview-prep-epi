package org.wb.projectEuler;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    //What is the largest prime factor of a number ?
    public static void main(String[] args) {
        System.out.println(largestPrimeFactor(13195));
        System.out.println(largestPrimeFactor(600851475143L));
    }

    private static long largestPrimeFactor(long number) {
        long primeFactor = 0L;
        List<Long> primeFactors = new ArrayList<>();

        long sqrtNum = (long) Math.sqrt(number);

        for (int i = 2; i < sqrtNum; i++) {
            while( number % i == 0 ){
                number = number/i;
                primeFactors.add((long)i);
            }
        }

        for(long prime : primeFactors){
            primeFactor = Math.max(prime, primeFactor);
        }

        return primeFactor;
    }

}
