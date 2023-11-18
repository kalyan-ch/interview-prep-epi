package org.wb.leetcode.interview150.arraysAndStrings;

public class GasStation {
    public static void main(String[] args) {
        int[] gas = {7, 1, 0, 11, 4};
        int[] cost = {5, 9, 1, 2, 5};

        System.out.println(startRoundTripFrom(gas, cost));
    }

    private static int startRoundTripFrom(int[] gas, int[] cost) {
        int start = 0, totalSurplus = 0, startTank = 0;

        for(int i = 0; i < gas.length; i++){
            totalSurplus += gas[i] - cost[i];
            startTank += gas[i] - cost[i];

            if(startTank < 0){
                startTank = 0;
                start = i + 1;
            }
        }

        return (totalSurplus < 0 )? -1 : start;
    }
}
