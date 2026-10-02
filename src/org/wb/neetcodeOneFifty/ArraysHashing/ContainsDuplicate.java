package org.wb.neetcodeOneFifty.ArraysHashing;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicateHash(nums));

        nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicateHash(nums));

    }

    public static boolean containsDuplicateHash(int[] nums) {
        var seenMap = new HashSet<Integer>();
        for(int num: nums) {
            if(seenMap.contains(num)) {
                return true;
            }
            seenMap.add(num);
        }
        return false;
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int i, j = 1, n = nums.length;
        for(i = 0; i < n && j < n; i++) {
            if(nums[i] == nums[j]){
                return true;
            }
            j++;
        }
        return false;
    }
}
