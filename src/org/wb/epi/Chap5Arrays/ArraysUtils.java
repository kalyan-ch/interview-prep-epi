package org.wb.epi.Chap5Arrays;

import java.util.List;

public class ArraysUtils {

    public static void printIntArray(int[] array){
        for(int a: array){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void printCharArray(char[] array){
        for(char a: array){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void print2dArray(int[][] array){
        for(int[] arr: array){
            for(int a: arr)
                System.out.print(a+" ");

            System.out.println();
        }
    }

    public static void printIntList(List<Integer> array){
        for(Integer a: array){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void printInt2dList(List<List<Integer>> array){
        for(List<Integer> a: array){
            printIntList(a);
        }
        System.out.println();
    }

    public static void printStrList(List<String> array){
        for(String a: array){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i] ;
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] getPrefixSumArr(int[] nums){
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] + prefix[i-1];
        }

        return prefix;
    }
}
