package org.wb.projectEuler;

public class Problem1 {

    public static void main(String[] args) {
        System.out.println(sumOfAll3Or5(1000));
    }

    // get the sum of all multiples of 3 or 5 below a number
    private static int sumOfAll3Or5(int number) {
        int sum = 0;
        for (int i = 3; i < number; i++) {
            if(i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }
        return sum;
    }


}
