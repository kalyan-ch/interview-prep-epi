package org.wb.epi.Chap10Heaps;

import org.wb.epi.Chap5Arrays.ArraysUtils;
import java.util.*;

public class TenThreeAlmostSortedArray{
    
    //sort an almost sorted array in which any element is at most 2 away from position
    public static void main(String[] args) {
        int[] arr = {3, -1, 2, 6, 4, 5, 8};

        int[] sortedArr = sortAlmostSorted(arr, 2);
        ArraysUtils.printIntArray(sortedArr);


    }

    public static int[] sortAlmostSorted(int[] arr, int k){
        int[] result = new int[arr.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0, j = 0;
        while(i < k){
            minHeap.add(arr[i]);
            i++;
        }

        while(i < arr.length){
            minHeap.add(arr[i]);
            result[j++] = minHeap.poll();
            i++;
        }

        while(!minHeap.isEmpty()){
            result[j++] = minHeap.poll();
        }

        return result;
    }

}