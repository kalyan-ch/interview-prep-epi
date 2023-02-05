package org.wb.leetcode.easy;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class Prob977SquaresSortedArray {
    public static void main(String[] args) {
        int[] nums = {-15, -14, -8};
        int[] nums2 = {11, 13, 19};
        int[] nums3 = {-1, 2, 2};
        int[] squareNums = sortedSquares(nums);
        int[] squareNums2 = sortedSquares(nums2);
        int[] squareNums3 = sortedSquares(nums3);
        ArraysUtils.printIntArray(squareNums);
        ArraysUtils.printIntArray(squareNums2);
        ArraysUtils.printIntArray(squareNums3);
    }

    private static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int firstPositiveIdx = 0;
        for (int num : nums) {
            if (num >= 0)
                break;
            firstPositiveIdx++;
        }

        for (int i = 0; i < n; i++) {
            nums[i] *= nums[i];
        }

        int i = firstPositiveIdx, j = firstPositiveIdx - 1;
        int k = 0;
        while(j >= 0 && i < n){
            if(nums[i] > nums[j]){
                result[k] = nums[j];
                j--;
            } else {
                result[k] = nums[i];
                i++;
            }
            k++;
        }

        while(i < n){
            result[k++] = nums[i++];
        }

        while( j >= 0){
            result[k++] = nums[j--];
        }
        return result;

    }
}
