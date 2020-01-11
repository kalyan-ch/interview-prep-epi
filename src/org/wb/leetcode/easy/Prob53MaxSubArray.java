package org.wb.leetcode.easy;

public class Prob53MaxSubArray {

    //find the subarray that has the largest sum and return the sum
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }

    private static int maxSubArray(int[] arr){
        int result = Integer.MIN_VALUE, temp = arr[0];

        for(int i = 1; i < arr.length; i++){
            temp = Math.max(temp + arr[i], arr[i]);
            result = Math.max(temp, result);
        }


        return result;
    }


}
