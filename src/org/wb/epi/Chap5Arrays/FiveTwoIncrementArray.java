package org.wb.epi.Chap5Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.wb.epi.Chap5Arrays.ArraysUtils.printIntList;

public class FiveTwoIncrementArray {

    public static void main(String[] args) {
        List<Integer> number1 = new ArrayList<>();
        number1.add(9);
        number1.add(5);
        number1.add(8);

        List<Integer> number2 = Arrays.asList(9,9,2,5);

        addOneToList(number1);
        printIntList(number1);

        List<Integer> result = addTwoListNumbers(number1, number2);
        printIntList(result);
    }

    private static void addOneToList(List<Integer> number) {
        int carry = 0, i = number.size()-1;
        number.set(i, number.get(i)+1);
        while(i >= 0){
            int digit = number.get(i);
            int sum = carry + digit;
            carry = (sum > 9) ? 1 : 0;
            number.set(i, sum%10);
            i--;
        }
        if(carry == 1){
            number.set(0, 1);
            number.add(0);
        }

    }

    //variant 1
    private static List<Integer> addTwoListNumbers(List<Integer>num1, List<Integer>num2){

        List<Integer> result = new ArrayList<>();
        int n = num1.size(), m = num2.size();
        int p = Math.max(m, n) + 1;
        for (int i = 0; i < p; i++){
            result.add(0);
        }

        int carry = 0, i = n - 1, j = m - 1, k = p - 1;
        while(i >= 0 || j >= 0){
            int digit1 = (i >= 0) ? num1.get(i) : 0;
            int digit2 = (j >= 0) ? num2.get(j) : 0;
            int sum = carry + digit1 + digit2;
            carry = (sum > 9) ? 1 : 0;
            result.set(k, sum % 10);
            i--; j --; k--;
        }

        if(carry == 1){
            result.set(0, carry);
        }else{
            result.remove(0);
        }

        return  result;
    }
}
