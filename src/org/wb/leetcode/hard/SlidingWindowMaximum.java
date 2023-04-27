package org.wb.leetcode.hard;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.*;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, -2, 6, 5, 3, 2};
        int[] maxNums = maxSlidingWindow(nums, 3);

        ArraysUtils.printIntArray(maxNums);
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k  + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++) {
            while(!q.isEmpty() && nums[q.getLast()] < nums[i]){
                q.pop();
            }

            q.addLast(i);

            if(q.getFirst() + k == i){
                q.removeFirst();
            }

            if(i + 1 >= k) {
                result[i - k + 1] = nums[q.getFirst()];
            }
        }

        return result;
    }
}
