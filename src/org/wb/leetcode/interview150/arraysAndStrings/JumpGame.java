package org.wb.leetcode.interview150.arraysAndStrings;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 0, 4};

        System.out.println(canJump(nums));
        System.out.println(jump(nums));
    }

    private static boolean canJump(int[] nums) {

        int lastGoodPos = nums.length - 1;

        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= lastGoodPos)
                lastGoodPos = i;
        }

        return lastGoodPos == 0;
    }

    private static int jump(int[] nums) {
        if(nums.length < 2){
            return 0;
        }

        int level=0, currentMax=0, i=0, nextMax=0;

        while(currentMax-i+1>0){
            level++;
            while(i<=currentMax){
                nextMax = Math.max(nextMax, nums[i]+i);
                if(nextMax >= nums.length - 1){
                    return level;
                }
                i++;
            }
            currentMax = nextMax;
        }

        return 0;
    }
}
