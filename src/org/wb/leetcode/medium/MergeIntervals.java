package org.wb.leetcode.medium;

public class MergeIntervals {
    //merge overlapping intervals
    public static void main(String[] args) {
        int[][] intervals = {{1,4}, {2,6}, {2,5}};
        int[][] result = merge(intervals);
        for(int[] interval: result){
            System.out.println("["+interval[0]+" -> "+interval[1]+"]");
        }
    }

    private static int[][] merge(int[][] intervals){
        int[][] result = {};

        return result;
    }

}
