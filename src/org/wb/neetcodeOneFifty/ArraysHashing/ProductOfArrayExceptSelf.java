package org.wb.neetcodeOneFifty.ArraysHashing;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[][] numses = {{-1, 0, 1, 2, 3}, {1, 2, 4, 6}};
        for(int[] nums: numses) {
            int[] prod = productExceptSelf(nums);
            ArraysUtils.printIntArray(prod);
        }

    }

    public static int[] productExceptSelf(int[] nums) {
        var n = nums.length;
        var result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        var postfix = 1;
        for (int i = n - 1; i >= 0 ; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}
