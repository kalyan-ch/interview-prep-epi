package org.wb.Chap5Arrays;

import static org.wb.Chap5Arrays.ArraysUtils.printArray;
import static org.wb.Chap5Arrays.ArraysUtils.swap;

public class FiveFIveDeleteDupsSortedArr {

    public static void main(String[] args) {
        int[] arr = {2,2,4,5,6,7,7,8};
        int[] arr2 = {2, 3, 5, 5, 7, 11, 11, 11, 13};
        int[] arr3 = {2, 2, 3, 3, 5};
        int[] arr4 = {2, 4, 3, 2, 1};
        //deleteDupsFromSortedArr(arr);
        deleteDupsFromSortedArr(arr3);
        deleteKeyFromArr(arr4, 2);
        printArray(arr3);
        printArray(arr4);
    }

    private static void deleteDupsFromSortedArr(int[] arr) {
        int i = 0, j = 1;
        // j acts as a index for subarray that contains unique elements
        while( i < arr.length){
            if(arr[i] != arr[j-1]){
                arr[j++] = arr[i];
            }
            i++;
        }
    }

    private static void deleteKeyFromArr(int[] arr, int key){
        int i = 0, j = 0;
        // j acts as a index for subarray that contains all elements that are not key
        while( i < arr.length){
            if(arr[i] != key){
                arr[j++] = arr[i];
            }
            i++;
        }
    }

}
