package org.wb.leetcode.interview150.dynamicPorgramming;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {2, 5, 7};
        System.out.println(coinChange(coins, 20));
    }

    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0)
                    dp[i] = Math.min(dp[i], (1 + dp[i - coins[j]]) );
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
