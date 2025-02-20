package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.stream.IntStream;

public class KRadiusSubArrays {
    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        int[] avg = getAverages(nums, 3);

        ArraysUtils.printIntArray(avg);

        int[] nums2 = new int[100000];
        IntStream.range(0, 100000).forEach(i -> nums2[i] = 100000);
        System.out.println(nums2.length);
    }

    private static int[] getAverages(int[] nums, int k) {
        if(k == 0){
            return nums;
        }

        int n = nums.length;
        int[] avg = new int[n];

        for(int i = 0; i < k && i < n; i++){
            avg[i] = -1;
            avg[n - 1 - i] = -1;
        }

        if(k > n){
            return avg;
        }

        int firstSum = 0, size = 2 * k + 1;

        for(int i = 0; i < n && i < size; i++){
            firstSum += nums[i];
        }

        avg[k] = firstSum / size;

        for(int i = k + 1; i < n - k; i++){
            firstSum -= nums[i - k - 1];
            firstSum += nums[i + k];

            avg[i] = firstSum / size;
        }

        return avg;
    }
}
