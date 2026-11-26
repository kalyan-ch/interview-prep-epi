package org.wb.neetcodeOneFifty.BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,2,4,6,8};
        System.out.println(binarySearch(nums, 3));

        int[] nums2 = {5};
        System.out.println(binarySearch(nums2, 5));

    }

    public static int binarySearch(int[] nums, int target) {
        int result = -1;

        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                result = mid;
                return result;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
