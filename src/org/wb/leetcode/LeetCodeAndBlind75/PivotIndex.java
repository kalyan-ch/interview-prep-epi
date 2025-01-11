package org.wb.leetcode.LeetCodeAndBlind75;

public class PivotIndex {
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];

        prefixSum[0] = nums[0];

        for(int i = 1; i < n; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for(int i = 0; i < n; i++){
            if(i == 0){
                if(prefixSum[n - 1] - prefixSum[i] == 0)
                    return 0;
            } else if(prefixSum[n - 1] - prefixSum[i] == prefixSum[i - 1]){
                return i;
            }
        }

        return -1;
    }
}
