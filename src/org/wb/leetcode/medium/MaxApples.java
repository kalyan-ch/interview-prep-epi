package org.wb.leetcode.medium;

import java.util.Arrays;

public class MaxApples {
    public static void main(String[] args) {
        int[] weight = {3000, 1000, 2000, 4000, 2000};
        System.out.println(maxNumberOfApples(weight));
    }

    public static int maxNumberOfApples(int[] weight) {
        int[] dp = new int[weight.length + 1];
        Arrays.sort(weight);
        dp[0] = 0;
        int runningWeight = 0;
        for(int i = 1; i < dp.length; i++){

            int countApple =  0;
            if (weight[i - 1] + runningWeight <= 5000){
                countApple = 1;
                runningWeight += weight[i - 1];
            }

            dp[i] = dp[i - 1] + countApple;
        }


        return dp[weight.length];
    }
}
