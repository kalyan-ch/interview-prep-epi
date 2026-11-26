package org.wb.neetcodeOneFifty.BinarySearch;

public class MinimumInRotatedSortedArr {
    public static void main(String[] args) {
        int[] nums = {11, 15, 17, 2, 4, 5, 8, 10};
        System.out.println(minNumber(nums));
    }

    private static int minNumber(int[] nums) {
        var result = nums[0];
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            if (nums[l] < nums[r]) {
                result = Math.min(result, nums[l]);
                break;
            }

            var m = (l + r) / 2;

            result = Math.min(nums[m], result);
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return result;
    }

}
