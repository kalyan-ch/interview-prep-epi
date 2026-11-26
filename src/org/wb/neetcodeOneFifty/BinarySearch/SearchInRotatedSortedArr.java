package org.wb.neetcodeOneFifty.BinarySearch;

public class SearchInRotatedSortedArr {
    public static void main(String[] args) {
        int[] nums = {11, 15, 17, 2, 4, 5, 8, 10};
        System.out.println(search(nums, 4));
        int[] nums2 = {4,5,6,7,0,1,2};
        System.out.println(search(nums2, 0));
    }

    public static int search(int[] nums, int target) {
        int result = -1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;

            if(nums[m] == target) {
                return m;
            }

            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return result;
    }
}
