package org.wb.epi.Chap5Arrays;

public class FiveSixBuyAndSellStocks {

    //buy and sell a stock once
    //determine the maximum profit when you're buying once and selling once
    public static void main(String[] args) {
        double[] stockPrices = {27.0, 28.5, 20.44, 25.23, 22.35, 23.56, 28.97};
        System.out.println(buyAndSellStockOnce(stockPrices));

        int[] arr = {2, 2, 2, 2, 6, 6, 6, 8};
        System.out.println(lengthOfLongestEqualSubArr(arr));

    }



    private static double buyAndSellStockOnce(double[] stockPrices) {
        double maxProfit= 0, minStock = Double.MAX_VALUE;
        for(int i=0; i < stockPrices.length; i++){
            minStock = Math.min(minStock, stockPrices[i]);
            maxProfit = Math.max(maxProfit, stockPrices[i]-minStock);
        }
        return maxProfit;
    }

    //variant 1
    //find the length of longest subarray in which all elements are equal
    private static int lengthOfLongestEqualSubArr(int[] arr) {
        int maxLength = 0, runningCounter = 1;
        for(int i = 0; i < arr.length - 1 ; i++){
            if(arr[i] != arr[i+1]){
                maxLength = Math.max(maxLength, runningCounter);
                runningCounter = 1;
            }
            runningCounter++;
        }
        return maxLength;
    }


}
