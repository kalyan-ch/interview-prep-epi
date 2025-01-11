package org.wb.leetcode.medium;

public class ProductNumbersButSelf {

    public static void main(String[] args) {
        int[] arr = {3, 4, -2, 1, 5, 6};
        int[] res = productExceptSelf(arr);
        for(int i: res)
            System.out.print(i+", ");

    }

    private static int[] productExceptSelf(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        // first pass - multiply elements from left
        result[0] = 1;
        for(int i = 1; i < n; i++){
            result[i] = result[i-1] * arr[i-1];
        }

        //second pass - multiply elements from right
        int right = 1;
        for(int i = n-1; i >=0; i--){
            result[i] *= right;
            right *= arr[i];
        }
        return result;
    }

}
