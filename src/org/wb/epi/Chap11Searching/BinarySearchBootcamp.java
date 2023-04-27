package org.wb.epi.Chap11Searching;

public class BinarySearchBootcamp {
    public static void main(String[] args) {
        int[] arr = {2, 7, 13, 15, 20, 32};
        int target = 8, left = 0, right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == target){
                System.out.println("found at "+ mid);
                break;
            } else if(arr[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left+" "+right);

    }
}
