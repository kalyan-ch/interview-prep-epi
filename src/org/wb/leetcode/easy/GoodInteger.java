package org.wb.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class GoodInteger {
    public static void main(String[] args) {
        System.out.println(rotatedDigits(857));
    }

    public static int rotatedDigits(int n) {
        Map<Integer, Integer> numRotateMap = new HashMap<>();
        numRotateMap.put(0, 0);
        numRotateMap.put(1, 1);
        numRotateMap.put(2, 5);
        numRotateMap.put(5, 2);
        numRotateMap.put(6, 9);
        numRotateMap.put(8, 8);
        numRotateMap.put(9, 6);

        int count = 0;

        for(int i = 1; i <= n ; i++){
            if(i == 300){
                System.out.println("stop");
            }
            if(i < 10){
                if(numRotateMap.containsKey(i) && numRotateMap.get(i) != i){
                    count++;
                }
            } else {
                int x = i;
                StringBuilder sb = new StringBuilder();

                while(x != 0){
                    int dig = x % 10;
                    if(!numRotateMap.containsKey(dig)){
                        sb = new StringBuilder();
                        break;
                    }
                    int revDig = numRotateMap.get(dig);
                    sb.append(revDig);
                    x /= 10;
                }

                if(!sb.toString().isEmpty()){
                    int newNum = Integer.parseInt(sb.reverse().toString());
                    if(newNum != i){
                        count++;
                    }
                }

            }
        }

        return count;
    }
}
