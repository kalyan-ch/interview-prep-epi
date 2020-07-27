package org.wb.Misc;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Sample {

    public static void main(String[] args) {
        int[] result = solution(new int[]{1,2,2,3,3,4}, 1);
        for(int i: result){
            System.out.println(i);
        }
    }

    public static int[] solution(int[] data, int n) {
        // remove all ints from data that occur more than n times
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num: data){
            int count = countMap.getOrDefault(num, 0);
            countMap.put(num, ++count);
        }

        for(int num: data){
            if(countMap.get(num) <= n){
                res.add(num);
            }
        }

        int[] result = new int[res.size()];
        int i = 0;
        for(int num: res){
            result[i++] = num;
        }

        return result;
    }


}
