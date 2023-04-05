package org.wb.Misc;

public class NiSumTest3 {
    public static void main(String[] args) {
        int[] nums1 = {1,3}, nums2 = {2};

        int[] nums4 = {1,2}, nums3 = {3,4};

        int[] nums5 = {3, 5, 7, 12, 18}, nums6 = {4, 6, 8, 11, 19, 22};

        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays(nums3, nums4));
        System.out.println(findMedianSortedArrays(nums5, nums6));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2){
        double result = 0;

        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while(i < nums1.length && j < nums2.length){

            if(nums1[i] < nums2[j]){
                merged[k] = nums1[i++];
            } else {
                merged[k] = nums2[j++];
            }

            k++;
        }

        if(j < nums2.length){
            while(j < nums2.length){
                merged[k++] = nums2[j++];
            }
        }

        if(i < nums1.length){
            while(i < nums1.length){
                merged[k++] = nums1[i++];
            }
        }

        for(int a: merged){
            System.out.print(a+" ");
        }

        System.out.println();

        if(merged.length % 2 == 0){
            result = (merged[(merged.length / 2) - 1] + merged[merged.length / 2]) / 2.0;
        } else {
            result = merged[merged.length / 2];
        }

        return result;
    }
}
