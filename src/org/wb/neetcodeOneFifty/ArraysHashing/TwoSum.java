package org.wb.neetcodeOneFifty.ArraysHashing;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2 , 7, 1, 4, 5, 11};
        int[] indices = twoSum(nums, 10);
        System.out.println(nums[indices[0]]+" "+nums[indices[1]]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = {0, 0};
        var prevMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var diff = target - nums[i];
            if(prevMap.containsKey(diff)){
                return new int[]{prevMap.get(diff), i};
            }
            prevMap.put(nums[i], i);
        }
        return result;
    }
}
