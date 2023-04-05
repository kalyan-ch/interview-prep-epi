package org.wb.Misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NisumTest {
    public static void main(String[] args) {
        int[] nums = {5,8,2,4,1,11,15};
        int target = 9;
        int[] result = findTarget(nums, target);
        System.out.println(result[0]+" "+result[1]);
    }

    private static int[] findTarget(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, Integer> diffMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            diffMap.put(target - nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (diffMap.containsKey(num)) {
                result[0] = i;
                result[1] = diffMap.get(num);
                break;
            }
        }

        return result;
    }
}
