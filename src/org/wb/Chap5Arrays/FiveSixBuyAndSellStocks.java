package org.wb.Chap5Arrays;

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
        int maxLength = 0, runningCounter = 0, runningElement = 0;
        for(int i = 0; i < arr.length; i++){
            if(runningElement != arr[i]){
                runningElement = arr[i];
                maxLength = Math.max(maxLength, runningCounter);
                runningCounter = 0;
            }
            runningCounter++;
        }

        return maxLength;
    }


}
