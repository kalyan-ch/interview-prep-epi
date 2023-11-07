package org.wb.leetcode.interview150.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("XIX"));
    }

    private static int romanToInt(String s) {

        Map<Character, Integer> romanToDecMap = new HashMap<>();
        romanToDecMap.put('I', 1);
        romanToDecMap.put('V', 5);
        romanToDecMap.put('X', 10);
        romanToDecMap.put('L', 50);
        romanToDecMap.put('C', 100);
        romanToDecMap.put('D', 500);
        romanToDecMap.put('M', 1000);

        if(romanToDecMap.containsKey(s)){
            return romanToDecMap.get(s);
        }

        int res = 0, prevRes = 0;

        for(int i = 0; i < s.length(); i++){
            int val = romanToDecMap.get(s.charAt(i));
            if(prevRes != 0 && prevRes < val){
                res -= prevRes;
                res += val - prevRes;
            }else
                res += val;

            prevRes = val;
        }

        return res;
    }
}
