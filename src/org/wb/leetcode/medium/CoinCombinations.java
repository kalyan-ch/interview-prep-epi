package org.wb.leetcode.medium;

public class CoinCombinations {

    public static void main(String[] args) {
        int[] coins = {2, 3, 7};
        System.out.println(coinChange(coins, 12));
    }

    private static int coinChange(int[] coins, int amount) {
        //initialize 2d array for holding intermediate results
        int[] memoizedResults = new int[amount+1];
        memoizedResults[0] = 1;
        for(int coin : coins){
            for(int sum = 1; sum <= amount; sum++){
                if(sum >= coin)
                    memoizedResults[sum] += memoizedResults[sum-coin];
            }
        }
        return memoizedResults[amount];
    }

}
