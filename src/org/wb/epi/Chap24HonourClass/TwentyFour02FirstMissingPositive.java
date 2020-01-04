package org.wb.epi.Chap24HonourClass;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class TwentyFour02FirstMissingPositive {

    // find the first missing positive integer
    public static void main(String[] args) {
        int[] arr = {2,1,3,4,-5};
        int[] arr1 = {2,1,3,5,-5};
        int[] arr2 = {2,0,3,4,-5};
        System.out.println(firstMissingPositive(arr));
        System.out.println(firstMissingPositive(arr1));
        System.out.println(firstMissingPositive(arr2));
    }

    private static int firstMissingPositive(int[] arr) {
        int result = 0;

        for(int i = 0; i < arr.length; i++){
            while(arr[i] > 0 && arr[i] <= arr.length
                    && arr[arr[i] - 1] != arr[i]){
                ArraysUtils.swap(arr, i, arr[i]-1);
            }
        }

        for(int i = 0; i< arr.length; i++){
            if(arr[i] != i+1){
                return i+1;
            }
        }

        return result;
    }


}
