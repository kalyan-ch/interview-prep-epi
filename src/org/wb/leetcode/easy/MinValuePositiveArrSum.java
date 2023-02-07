package org.wb.leetcode.easy;

public class MinValuePositiveArrSum {
    public static void main(String[] args) {
        int[] nums = {-3, 2, -3, 4, 2};
        System.out.println(minStartValue(nums));
    }

    public static int minStartValue(int[] nums) {

        int currSum = nums[0];
        int result = 1;
        if(currSum < 1){
            result = Math.max(1, Math.abs(nums[0]) + 1);
        }

        for (int i = 1; i < nums.length; i++) {
            currSum += nums[i];
            if(currSum < 1){
                result = Math.max(result, Math.abs(currSum) + 1);
            }
        }

        return result;
    }
}
