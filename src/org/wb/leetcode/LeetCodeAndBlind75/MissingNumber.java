package org.wb.leetcode.LeetCodeAndBlind75;

import java.util.HashSet;

public class MissingNumber {
    public static void main(String[] args) {
        int[][] numArrays = {{3,0,1}, {0,1}, {9,6,4,2,3,5,7,0,1}};

        for(int[] arr: numArrays){
            //System.out.println(missingNumberHashSet(arr));
            //System.out.println(missingNumberXOR(arr));
            System.out.println(missingNumberSum(arr));
        }
    }

    private static int missingNumberSum(int[] arr){
        int n = arr.length, sum = (n * (n + 1) )/ 2;
        int actualSum = 0;
        for(int i : arr){
            actualSum += i;
        }

        return sum - actualSum;
    }

    private static int missingNumberXOR(int[] arr) {
        int missing = 0, i = 0;

        while(i < arr.length) {
            missing = missing ^ i ^ arr[i++];
        }

        return missing ^ i;
    }

    private static int missingNumberHashSet(int[] arr) {
        int result = 0;
        var numSet = new HashSet<Integer>();

        for(int i: arr){
            numSet.add(i);
        }

        for(var i = 0; i <= arr.length; i++){
            if(!numSet.contains(i)){
                result = i;
                break;
            }
        }

        return result;
    }


}
