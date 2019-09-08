package org.wb.projectEuler;

import java.util.HashSet;
import java.util.Set;

public class Problem5 {

    public static void main(String[] args) {

        findSmallestMultipleOfAllBelow(10);

        //findSmallestMultipleOfAllBelow(20);
    }

    private static int findSmallestMultipleOfAllBelow(int n){
        int multiple = 1;
        Set<Integer> uniquePrimes = new HashSet<>();
        uniquePrimes.add(2);
        uniquePrimes.add(3);

        for(int i = 4; i <= n; i++){
            findPrimes(i, uniquePrimes);
        }

        for(int i: uniquePrimes){
            System.out.println(i);
        }

        return multiple;
    }

    private static void findPrimes(int number, Set<Integer> uniquePrimes) {

        long sqrtNum = (long) Math.sqrt(number);
        for (int i = 2; i < sqrtNum; i++) {
            while( number % i == 0 ){
                number = number/i;
                uniquePrimes.add(i);
            }
        }

    }



}
