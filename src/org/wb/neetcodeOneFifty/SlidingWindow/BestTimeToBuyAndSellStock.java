package org.wb.neetcodeOneFifty.SlidingWindow;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int lowest = prices[0];
        int result = 0;
        for(int i = 0; i < prices.length; i++) {
            lowest = Math.min(prices[i], lowest);
            int profit = prices[i] - lowest;

            result = Math.max(profit, result);
        }

        return result;
    }
}
