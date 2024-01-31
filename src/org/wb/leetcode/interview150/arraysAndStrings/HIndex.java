package org.wb.leetcode.interview150.arraysAndStrings;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        int[][] citationsArr = {{3,0,6,1,5}, {1,3,1}, {4,3,2,1,7,5,6}, {0}, {7,7,7,7,7,7,7}};

        for(int[] citations: citationsArr){
            System.out.println(hIndex(citations));
        }
    }

    private static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length, i = 0, j = n - 1;

        while(i < n && citations[j] > i) {
            i++;
            j--;
        }

        return i;
    }


}
