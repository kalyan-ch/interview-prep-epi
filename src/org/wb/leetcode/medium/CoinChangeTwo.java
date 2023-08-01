package org.wb.leetcode.medium;

public class CoinChangeTwo {
    public static void main(String[] args) {
        int[] coins = {2, 5, 7};
        System.out.println(numWays(coins, 12));
    }

    public static int numWays(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin: coins) {
            for(int i = 1; i < dp.length; i++){
                if(i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }


        return dp[amount];
    }

}
