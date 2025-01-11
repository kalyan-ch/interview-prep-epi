package org.wb.leetcode.easy;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class SquaresSortedArr {
    public static void main(String[] args) {
        int[][] tests = {{-4,-1,0,3,10}, {-7,-3,2,3,11}, {-1,2,2}};
        for(int[] test: tests){
            int[] res = sortedSquares(test);
            ArraysUtils.printIntArray(res);
        }
    }

    private static int[] sortedSquares(int[] nums){
        int n = nums.length;
        int[] squares = new int[n];
        for(int i = 0; i < n; i++){
            squares[i] = nums[i] * nums[i];
        }

        int i = 1;
        while(i < n - 1) {
            if(squares[i] < squares[i - 1] && squares[i + 1] >= squares[i]){
                break;
            }
            i++;
        }

        int[] result = new int[n];
        int j = i, k = 0; i--;
        while(i >= 0 || j < n){

            int rightHalf = (j < n) ? squares[j] : Integer.MAX_VALUE;
            int leftHalf = (i >= 0) ? squares[i] : Integer.MAX_VALUE;

            if(leftHalf <= rightHalf){
                result[k] = leftHalf;
                i--;
            } else {
                result[k] = rightHalf;
                j++;
            }
            k++;
        }

        return result;
    }
}
