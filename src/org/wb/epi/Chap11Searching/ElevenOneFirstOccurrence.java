package org.wb.epi.Chap11Searching;

public class ElevenOneFirstOccurrence {

    public static void main(String[] args){
        int[] arr = {1, 2, 4, 4, 4, 9, 9, 9, 14};
        System.out.println(findFirstOccurenceOf(arr, 9));
        System.out.println(findFirstLargestEle(arr, 5));

    }

    //find first occurence of an element in a sorted array
    private static int findFirstOccurenceOf(int[] arr, int key){
        int result = -1, start = 0, end = arr.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] > key){
                end = mid-1;
            }else if (arr[mid] < key){
                start = mid + 1;
            }else{
                result = mid;
                end = mid - 1;
            }
        }

        return result;
    }


    //variant find first element that is greater than given element in sorted array
    private static int findFirstLargestEle(int[] arr, int key){
        int start = 0, end = arr.length - 1;

        while(start <= end){
            int mid = (start + end) /2;
            if(arr[mid] > key){
                end = mid - 1;
            }else if(arr[mid] < key){
                start = mid + 1;
            }else{
                start = mid + 1;
            }
        }

        return arr[start];
    }

}
