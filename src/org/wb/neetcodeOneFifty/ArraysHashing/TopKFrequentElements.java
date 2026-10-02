package org.wb.neetcodeOneFifty.ArraysHashing;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[][] numsList = {{1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 4, 2, 1, 3, 6}, {1, 2, 1, 2, 1, 2, 3, 1, 3, 2}, {7, 7}};
        int[] kValue = {3, 2, 1};
        for (int i = 0; i < numsList.length; i++) {
            int[] elements = topKFrequent(numsList[i], kValue[i]);
            ArraysUtils.printIntArray(elements);
        }
    }

    private static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        var freqList = new ArrayList<Set<Integer>>();
        for(int i = 0; i < nums.length + 1; i++) {
            freqList.add(new HashSet<>());
        }
        var freqMap = new HashMap<Integer, Integer>();

        for(int num: nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for(int num: nums) {
            var numSet = freqList.get(freqMap.get(num));
            numSet.add(num);
            freqList.set(freqMap.get(num), numSet);
        }

        int i = nums.length;
        int j = 0;
        while (i> 0) {
            if(!freqList.get(i).isEmpty()) {
                var numSet = freqList.get(i);
                for(int num: numSet) {
                    result[j++] = num;
                    if(j == k) {
                        return result;
                    }
                }
            }
            i--;
        }

        return result;
    }

}
