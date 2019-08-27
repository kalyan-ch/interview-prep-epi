package org.wb.projectEuler;

public class Problem2 {

    public static void main(String[] args) {
        System.out.println(sumOfEvenFibonacci(4000000));
    }

    //sum of even valued fibonacci numbers less than four million
    private static long sumOfEvenFibonacci(int number) {
        int a = 0, b = 1;
        long sum = 0;

        while(b < number){
            int fib = a + b;
            System.out.println(fib);
            if((fib & 1) == 0)
                sum += fib;

            a = b;
            b = fib;
        }

        return sum;
    }

}
