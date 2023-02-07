package org.wb.leetcode.easy;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class Prob283MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        int[] arr = {1};
        moveZeroes(nums);
        moveZeroes(arr);
        ArraysUtils.printIntArray(nums);
        ArraysUtils.printIntArray(arr);
    }

    public static void moveZeroes(int[] nums) {
        int j = 0;

        for( int i =0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                nums[i] = 0;
                j++;
            }
        }
    }
}
