package org.wb.leetcode.interview150.arraysAndStrings;

public class RemoveDupsSortedTwo {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 2};
        int k = removeDuplicates(arr);
        for(int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int removeDuplicates(int[] arr) {
        int i = 1, j = 0, count = 0;

        while( i < arr.length){
            if(arr[i] == arr[i - 1]) {
                if(count < 2) {
                    arr[++j] = arr[i];
                }
                count++;
            } else {
                count = 1;
                arr[++j] = arr[i];
            }
            i++;
        }

        return j + 1;
    }
}
