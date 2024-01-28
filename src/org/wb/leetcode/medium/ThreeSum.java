package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.*;

public class ThreeSum {
    // find 3 numbers within arr that add up to 0
    public static void main(String[] args) {
        int[][] arrays = {{-2,0,0,2,2}, {-1, 0, 1, 2, -1, -4}, {0, 1, 1}, {0, 0, 0}};

        for (int[] arr : arrays) {
            List<List<Integer>> triplets = threeSum(arr);

            ArraysUtils.printInt2dList(triplets);
        }

    }
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> resMap = new HashSet<>();
        Arrays.sort(nums); // O(nlogn)

        long start = System.currentTimeMillis();

        //search binarily to find the sum of three numbers
        int n = nums.length, tgt = 0, prev = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(prev == nums[i]) {
                continue;
            }
            int j = i+1, k = n-1;
            while(j < k){
                int sum2 = nums[i] + nums[j] + nums[k];
                if(sum2 == 0){
                    result.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                }else if(sum2 < 0)
                    j++;
                else
                    k--;
            }
            prev = nums[i];
        }

        long end = System.currentTimeMillis();

        System.out.println("time taken: "+ (end - start));



        return result;
    }

}
