package org.wb.leetcode.medium;

public class MinSubArraySum {
    public static void main(String[] args) {
        int[] nums = {10, 2, 3};
        System.out.println(minSubArrayLen(6, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int arrSum = 0;
        for (int i : nums) {
           arrSum += i;
        }

        if(arrSum < target){
            return 0;
        }

        int curr = 0, result = Integer.MAX_VALUE;
        int left = 0, right = 0;


        while(right < nums.length){
            if(curr < target){
                curr += nums[right];
            } else {
                result = Math.min(result, right - left + 1);
                curr -= nums[left];
                left++;
            }

            if(curr < target){
                right++;
            }
        }

        return result;
    }
}
