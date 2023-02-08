package org.wb.epi.Chap5Arrays;

import static org.wb.epi.Chap5Arrays.ArraysUtils.printIntArray;

public class FiveFIveDeleteDupsSortedArr {

    //delete duplicates from a sorted array

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 7, 7, 8};
        int[] arr2 = {2, 3, 5, 5, 7, 11, 11, 11, 13};
        int[] arr3 = {2, 2, 3, 3, 5};
        int[] arr4 = {2, 4, 3, 2, 1};
        deleteDupsFromSortedArr(arr);
        deleteDupsFromSortedArr(arr3);
        deleteKeyFromArr(arr2, 2);
        printIntArray(arr);
        printIntArray(arr3);
        printIntArray(arr4);
    }

    private static void deleteDupsFromSortedArr(int[] arr) {
        int i = 0, j = 0;
        // sub-array [0,j] contains only unique elements
        // therefore whenever arr[i] and arr[j] are not equal
        // j is moved to right and value is overwritten with arr[i]
        while( i < arr.length){
            if(arr[i] != arr[j]){
                arr[++j] = arr[i];
            }
            i++;
        }
    }

    private static void deleteKeyFromArr(int[] arr, int key){
        int i = 0, j = 0;
        // j is end-index for sub-array that contains all elements that are not key
        while( i < arr.length){
            if(arr[i] != key){
                arr[j++] = arr[i];
            }
            i++;
        }
    }

}
