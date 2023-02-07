package org.wb.leetcode.medium;

public class MaxConsecutiveSumsIII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(maxConsecutiveOnes(nums, 2));
    }

    private static int maxConsecutiveOnes(int[] nums, int k) {
        int left = 0, right = 0, zeroes = k;

        while(right < nums.length && left < nums.length){
            if(nums[right] == 0){
                zeroes--;
            }

            if(zeroes < 0) {
                if(nums[left] == 0){
                    zeroes++;
                }
                left++;
            }
            right++;
        }

        return right - left;
    }
}
