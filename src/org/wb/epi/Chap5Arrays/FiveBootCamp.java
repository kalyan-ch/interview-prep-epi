package org.wb.epi.Chap5Arrays;

import static org.wb.epi.Chap5Arrays.ArraysUtils.printIntArray;
import static org.wb.epi.Chap5Arrays.ArraysUtils.swap;

public class FiveBootCamp {

    public static void main(String[] args) {
        int[] arr = {5, 8, 7, 3, 15, 16, 12, 6};
        evenFirst(arr);
        printIntArray(arr);
    }

    private static void evenFirst(int[] arr){
        int nextEven = 0, nextOdd = arr.length - 1;

        while(nextEven < nextOdd){
            if((arr[nextEven]&1) == 0){
                nextEven++;
            }else{
                swap(arr, nextEven, nextOdd--);
            }
        }

    }

}
