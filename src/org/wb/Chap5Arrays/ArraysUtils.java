package org.wb.Chap5Arrays;

import java.util.List;

public class ArraysUtils {

    public static void printArray(int[] array){
        for(int a: array){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void printList(List<Integer> array){
        for(Integer a: array){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i] ;
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
