package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        List<List<Integer>> res = combinationSum(nums, 7);
        ArraysUtils.printInt2dList(res);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> tempRes = new LinkedList<>();

        getCombos(target, 0, tempRes, candidates, result);

        return result;
    }

    private static void getCombos(int arrSum, int idx,  LinkedList<Integer> tempRes, int[] candidates, List<List<Integer>> result){
        if(arrSum == 0){
            result.add(new ArrayList<>(tempRes));
            return;
        } else if (arrSum < 0){
            return;
        }

        for(int i = idx; i < candidates.length; i++){
            tempRes.add(candidates[i]);
            getCombos(arrSum - candidates[i], i, tempRes, candidates, result);
            tempRes.removeLast();
        }
    }

}
