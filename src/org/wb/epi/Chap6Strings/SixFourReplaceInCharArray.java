package org.wb.epi.Chap6Strings;

import static org.wb.epi.Chap5Arrays.ArraysUtils.printCharArray;
import static org.wb.epi.Chap5Arrays.ArraysUtils.printIntArray;

public class SixFourReplaceInCharArray {

    public static void main(String[] args) {
        char[] arr = {'a','b','c','c','e'};
        printCharArray(arr);
        replaceAwithDDandRemoveB(arr);
        printCharArray(arr);

        int[] arr1 = {1,3,5,7,8,10};
        int[] arr2 = {2,4,6,8};
        int[] result = merge(arr1, arr2);

        printIntArray(result);

    }

    private static void replaceAwithDDandRemoveB(char[] arr) {
        int i = 0, j = 0, aCount = 0;
        char key = 'b';

        while( i < arr.length){
            if(arr[i] != key)
                arr[j++] = arr[i];
            if(arr[i] == 'a')
                aCount++;
            i++;
        }
        int curInd = j-1;
        j += aCount-1;
        int size = j+1;

        while(curInd >= 0){
            if (arr[curInd] == 'a'){
                arr[j--] = 'd';
                arr[j--] = 'd';
            }else
                arr[j--] = arr[curInd];

            curInd--;
        }
    }

    //variant
    //merge two sorted arrays into one array
    private static int[] merge(int[] arr1, int[] arr2){
        int i = 0, j = 0, n = arr1.length, m = arr2.length, k = 0;
        int[] result = new int[n+m];
        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                result[k++] = arr1[i++];
            }else if (arr1[i] > arr2[j]){
                result[k++] = arr2[j++];
            }else{
                result[k++] = arr1[i++];
                result[k++] = arr2[j++];
            }
        }


        while(k < n+m){
            if(j < m){
                result[k++] = arr2[j++];
            }else if(i < n){
                result[k++] = arr1[i++];
            }
        }


        return result;
    }


}
