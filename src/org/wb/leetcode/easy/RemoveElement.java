package org.wb.leetcode.easy;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {4,2,0,2,2,1,4,4,1,4,3,2};
        int len = removeElement(nums, 4);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int i = 0, j = nums.length - 1;

        while(j >= 0 && nums[j] == val){
            j--;
        }

        while(i <= j){
            if(nums[i] == val){
                nums[i] = nums[j];
                nums[j] = val;
                while(nums[j] == val){
                    j--;
                }

            }

            i++;
        }

        i = 0;
        while(i < nums.length && nums[i] != val){
            i++;
        }

        return i;
    }
}
