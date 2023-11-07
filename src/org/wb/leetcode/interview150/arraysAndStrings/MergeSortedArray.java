package org.wb.leetcode.interview150.arraysAndStrings;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {2,5,6,0,0,0};
        int[] arr2 = {1,4,7};

        merge(arr1, 3, arr2, 3);

        ArraysUtils.printIntArray(arr1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while(j >= 0) {
            if(i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
