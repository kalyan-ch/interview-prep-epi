package org.wb.leetcode.medium;

public class RemoveDupsFromSortedArrII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = removeDups(nums);
        System.out.println(k);
    }

    public static int removeDups(int[] nums) {
        int i = 1, j = 1, count = 1;

        for(i = 1; i < nums.length; i++){
            if(nums[i - 1] == nums[i]) {
                count++;
            } else {
                count = 1;
            }

            // overwriting the number at j
            // as long as count is <= 2
            // or elements are equal
            if(count <= 2){
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}
