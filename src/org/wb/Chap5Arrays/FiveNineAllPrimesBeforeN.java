package org.wb.Chap5Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FiveNineAllPrimesBeforeN {

    //get all prime numbers between 1 and N

    public static void main(String[] args) {
        ArraysUtils.printList(getAllPrimesBefore(250));
        ArraysUtils.printList(getAllPrimesBefore(2000));
        ArraysUtils.printList(getAllPrimesBefore(10));
    }

    //sieve of eratosthenes
    private static List<Integer> getAllPrimesBefore(int n) {
        List<Integer> primes = new ArrayList<>();
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n, true));
        //0 and 1 are not prime
        isPrime.set(0, false);
        isPrime.set(1, false);

        for(int i = 2; i < n; i++){
            if(isPrime.get(i)){
                primes.add(i);
                for(int j = 2*i; j < n; j+=i){
                    isPrime.set(j, false);
                }
            }
        }

        System.out.println(primes.size());
        return primes;
    }

}
