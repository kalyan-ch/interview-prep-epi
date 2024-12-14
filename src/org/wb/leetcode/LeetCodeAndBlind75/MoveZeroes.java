package org.wb.leetcode.LeetCodeAndBlind75;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {9,3,12,0,5,2,1,0,7,5};
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
                int temp = nums[j];
                nums[j++] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
