package org.wb.epi.Chap5Arrays;

import java.util.ArrayList;
import java.util.List;

public class FiveNinePrimesLessThanN {

    //find all primes less than the given number
    public static void main(String[] args) {
        List<Integer> primes = getAllPrimes(25);
        ArraysUtils.printIntList(primes);
    }

    private static List<Integer> getAllPrimes(int num) {
        List<Boolean> numbers = new ArrayList<>();
        for(int i = 0; i < num; i++){
            numbers.add(true);
        }

        for(int i = 2; i < num; i++){
            for(int j = 2*i; j < num; j+=i)
                numbers.set(j, false);
        }

        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i < num; i++){
            if(numbers.get(i))
                primes.add(i);
        }
        return primes;
    }

}
