package org.wb.epi.Chap5Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FiveTenArrPermutation {

    //get all permutations of an array
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 5, 6, 7, 4, 3, 9);
        List<Integer> perm = Arrays.asList(5, 0, 2, 4, 3, 6, 1);
        applyPermutation(arr, perm);
        ArraysUtils.printIntList(arr);
    }

    private static void applyPermutation(List<Integer> arr, List<Integer> perm) {
        List<Integer> newArr = new ArrayList<>();
        for(int i = 0; i< arr.size(); i++){
            int num = arr.get(perm.get(i));
            newArr.add(num);
        }

        for(int i = 0; i < arr.size(); i++){
            arr.set(i, newArr.get(i));
        }
    }

}
