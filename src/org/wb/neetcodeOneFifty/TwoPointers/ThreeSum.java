package org.wb.neetcodeOneFifty.TwoPointers;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        var res = threeSum(nums);
        ArraysUtils.printInt2dList(res);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {
            var target = nums[i];
            if(target > 0) {
                break;
            }

            if(i > 0 && target == nums[i - 1]) {
                continue;
            }

            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = target + nums[l] + nums[r];
                if(sum == 0) {
                    result.add(Arrays.asList(target, nums[l], nums[r]));
                    l++; r--;
                    while(l < r && nums[l] == nums[l -1]) {
                        l++;
                    }
                } else if(sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return result;
    }
}
