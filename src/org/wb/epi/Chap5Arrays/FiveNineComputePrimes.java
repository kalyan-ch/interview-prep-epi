package org.wb.epi.Chap5Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class FiveNineComputePrimes {
    public static void main(String[] args) {
        for(int i = 0;  i < 1000; i += 50){
            printAllPrimesBefore(i);
        }

    }

    public static void printAllPrimesBefore(int n){
        if(n < 2)
            return;

        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n+1, true));

        isPrime.set(0, false);
        isPrime.set(1, false);

        for (int i = 2; i < n; i++) {
            if(isPrime.get(i)){
                for (int j = i*2; j < n; j += i)
                    isPrime.set(j, false);

                System.out.print(i+" ");
            }

        }

        System.out.println();
        System.out.println(isPrime.stream().filter(s -> s).count());

    }
}
