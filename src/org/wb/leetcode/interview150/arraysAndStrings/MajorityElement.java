package org.wb.leetcode.interview150.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int n : nums) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }

        for(int k: countMap.keySet()) {
            if(countMap.get(k) > (nums.length / 2)){
                return k;
            }
        }

        return 0;
    }
}
