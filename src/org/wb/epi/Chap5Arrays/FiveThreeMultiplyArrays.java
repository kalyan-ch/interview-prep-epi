package org.wb.epi.Chap5Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.wb.epi.Chap5Arrays.ArraysUtils.printIntList;

public class FiveThreeMultiplyArrays {
    //multiply two numbers represented by arrays
    public static void main(String[] args) {
        int[] num1 = {5, 6, 5};
        int[] num2 = {7, 8, 7};

        List<Integer> result = multiplyArrays(num1, num2);
        printIntList(result);

    }

    private static List<Integer> multiplyArrays(int[] num1, int[] num2) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(num1.length + num2.length, 0));
        final int sign = (num1[0] * num2[0] < 0) ? -1 : 1;

        for(int i = num1.length - 1; i >= 0; i--){
            for(int j = num2.length - 1; j >= 0; j--){
                result.set(i+j+1, result.get(i+j+1) + num1[i]*num2[j]);
                result.set(i+j, result.get(i+j) + result.get(i+j+1)/10);
                result.set(i+j+1, result.get(i+j+1)%10);
            }
        }
        result.set(0, result.get(0)*sign);
        return result;
    }

}
