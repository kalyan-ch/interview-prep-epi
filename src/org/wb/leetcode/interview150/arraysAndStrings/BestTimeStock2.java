package org.wb.leetcode.interview150.arraysAndStrings;

public class BestTimeStock2 {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};

        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int result = 0, i = 1;

        while(i < prices.length) {
            if(prices[i] > prices[i-1]){
                result += (prices[i] - prices[i- 1]);
            }
            i++;
        }

        return result;
    }
}
