package org.wb.leetcode.easy;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementOne {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        int[] nextGreater = findNextGreater1(nums1, nums2);
        ArraysUtils.printIntArray(nextGreater);
    }

    private static int[] findNextGreater(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);

        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            idxMap.put(nums2[i], i);
        }

        for (int i = 0; i < nums1.length; i++) {
            int idx = idxMap.get(nums1[i]);

            for(int j = idx + 1; j < nums2.length; j++){
                if(nums2[j] > nums1[i]){
                    result[i] = nums2[j];
                    break;
                }
            }
        }

        return result;
    }

    private static int[] findNextGreater1(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];

        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while(!st.isEmpty() && nums2[st.peek()] < nums2[i]){
                int idx = st.pop();
                nextGreater.put(nums2[idx], nums2[i]);
            }
            st.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }

        return result;
    }

}
