package org.wb.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CoutingElements {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(countElements(arr));
    }

    private static int countElements(int[] arr) {
        var numCount = new HashMap<Integer, List<Integer>>();
        var count = 0;

        for(int i = 0; i < arr.length; i++){
            var idxList = numCount.getOrDefault(arr[i], new ArrayList<>());
            idxList.add(i);
            numCount.put(arr[i], idxList);
        }

        for(int i: arr){
            if(numCount.containsKey(i + 1)){
                var idxList = numCount.get(i + 1);
                idxList.remove(idxList.size() - 1);

                count++;

                if(idxList.isEmpty()){
                    numCount.remove(i + 1);
                }
            }
        }

        return count;
    }
}
