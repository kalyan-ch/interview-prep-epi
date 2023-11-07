package org.wb.leetcode.interview150.arraysAndStrings;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        ArraysUtils.printIntArray(nums);
    }

    public static void rotate(int[] nums, int k) {
        int[] lastK = new int[k];
        int j = 0, n = nums.length;

        for(int i = n - k; i < n; i++) {
            lastK[j++] = nums[i];
        }

        int i = n - k - 1; j = n - 1;
        while(i >= 0) {
            nums[j--] = nums[i--];
        }

        for(i = 0; i < k; i++){
            nums[i] = lastK[i];
        }
    }
}
