package org.wb.Chap5Arrays;

import static org.wb.Chap5Arrays.ArraysUtils.*;

public class FiveOneDutchFlag {

    // arrange numbers such that same numbers appear together
    public static void main(String[] args) {
        int[] arr = {0,1,0,1,0,2,1,2,2};
        int[] arr1 = {1,1,0,1,0,2,0,2,2};
        int[] arr2 = {1,1,0,1,0,2,0,2,2};
        dutchNationalFlag(arr);
        dutchNationalFlagNoOrder(arr2);
        dutchNationalFlag(arr1);
        printIntArray(arr);
        printIntArray(arr1);
        printIntArray(arr2);

    }

    private static void dutchNationalFlag(int[] arr) {
        int pivotIndex = 3, small = 0, equal = 0, large = arr.length;

        while(equal < large){
            if(arr[equal] < arr[pivotIndex]){
                swap(arr, equal++, small++);
            }else if(arr[equal] > arr[pivotIndex]){
                swap(arr, equal, --large);
            }else{
                ++equal;
            }
        }
    }

    //variant 1
    // arrange elements in array such that elements of equal value appear together
    private static void dutchNationalFlagNoOrder(int[] arr){
        int v0 = 0, v1 = 0, v2 = arr.length;

        while(v1 < v2){
            if(arr[v1] == 2){
                swap(arr, v0++, v1++);
            }else if(arr[v1] == 0){
                swap(arr, v1, --v2);
            }else{
                ++v1;
            }
        }
    }

}
