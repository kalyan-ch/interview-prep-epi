package org.wb.neetcodeOneFifty.TwoPointers;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 7, 8, 11, 13, 17};
        int[] res = twoSum(nums, 22);
        for(int i: res) {
            System.out.print(nums[i - 1]+",");
        }
        System.out.println();
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int[] result = new int[2];

        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if(sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return result;
    }
}
