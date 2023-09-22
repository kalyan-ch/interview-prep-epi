package org.wb.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    //merge overlapping intervals
    public static void main(String[] args) {
        int[][] intervals = {{2,6}, {1,4}, {8,10}};
        int[][] result = merge(intervals);
        for(int[] interval: result){
            System.out.println("["+interval[0]+" -> "+interval[1]+"]");
        }
    }

    private static int[][] merge(int[][] intervals){

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for (int[] inter: intervals) {
            if (merged.isEmpty() || merged.getLast()[1] < inter[0]){
                merged.add(inter);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], inter[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

}
