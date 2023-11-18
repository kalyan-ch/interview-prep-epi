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

        int result = 0, low = 1, high = citations.length;

        while(low <= high){
            int i = (low + high) / 2;
            if (areThereHPapers(i, citations)){
                result = i;
                low = i + 1;
            } else {
                high = i - 1;
            }
        }

        return result;
    }

    private static boolean areThereHPapers(int num, int[] citations) {
        int firstCeil = -1, low = 0, high = citations.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (citations[mid] >= num) {
                firstCeil = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (firstCeil != -1) && (citations.length - firstCeil) >= num;
    }
}
