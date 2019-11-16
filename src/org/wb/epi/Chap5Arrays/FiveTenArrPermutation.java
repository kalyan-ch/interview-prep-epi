package org.wb.epi.Chap5Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiveTenArrPermutation {

    //get all permutations of an array
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 5, 6, 7, 4, 3, 9);
        List<Integer> result = new ArrayList<>();
        permutateArr(arr, result);
        ArraysUtils.printIntList(result);
    }

    private static void permutateArr(List<Integer> arr, List<Integer> result) {
    }

}
