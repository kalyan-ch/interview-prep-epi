package org.wb.leetcode.easy;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.HashMap;
import java.util.Map;


public class Prob1TwoSum {

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 6};
        int[] result = twoSum(arr, 10);

        ArraysUtils.printIntArray(result);

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = {0,0};

        Map<Integer, Integer> numMaps = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int j = numMaps.getOrDefault(target-nums[i], -1);
            if( j == -1){
                numMaps.put(target-nums[i], i);
            }
        }

        for(int i = 0; i < nums.length; i++){
            int j = numMaps.getOrDefault(nums[i], -1);
            if( j != -1 && i != j ){
                result[0] = i;
                result[1] = j;
                break;
            }
        }

        return result;
    }


}
