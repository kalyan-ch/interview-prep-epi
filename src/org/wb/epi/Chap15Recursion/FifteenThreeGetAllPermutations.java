package org.wb.epi.Chap15Recursion;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.*;
import java.util.stream.Collectors;

public class FifteenThreeGetAllPermutations {

    public static void main(String[] args) {
        int[] nums = {4, 0, 2};
        List<List<Integer>> permutations = permute(nums);
        ArraysUtils.printInt2dList(permutations);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        getPermutations(0, numList, result);
        return result;
    }


    private static void getPermutations(int i, List<Integer> numList, List<List<Integer>> result){
        if(i == numList.size() - 1){
            result.add(new ArrayList<>(numList));
            return;
        }

        for(int k = i; k < numList.size(); k++){
            Collections.swap(numList, k, i);
            getPermutations(i + 1, numList, result);
            Collections.swap(numList, k, i);
        }
    }
}
