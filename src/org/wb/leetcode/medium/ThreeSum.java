package org.wb.leetcode.medium;

import java.util.*;

public class ThreeSum {
    // find 3 numbers within arr that add up to 0
    public static void main(String[] args) {
        int[] arr = {-2,0,1,1,2};
        List<List<Integer>> triplets = threeSum(arr);

        for(List<Integer> trip : triplets){
            for(int a: trip){
                System.out.print(a+", ");
            }
            System.out.println();
        }

    }
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> resMap = new HashMap<>();
        Arrays.sort(nums); // O(nlogn)

        //search binarily to find the sum of three numbers
        int n = nums.length, tgt = 0;
        for(int i = 0; i < n; i++){
            int j = i+1, k = n-1;
            while(j < k){
                int sum2 = nums[k] + nums[j];
                int diff = tgt - nums[i];
                if(sum2 == diff){
                    String tripLet = nums[i]+","+nums[j]+","+nums[k];
                    resMap.put(tripLet, 1);
                    j++;
                }else if(sum2 < diff)
                    j++;
                else
                    k--;
            }
        }

        for(String tripLet: resMap.keySet()){
            String[] arr = tripLet.split(",");
            List<Integer> tripList = new ArrayList<>();
            for(String s: arr){
                tripList.add(Integer.parseInt(s));
            }
            result.add(tripList);
        }

        return result;
    }

}
