package org.wb.leetcode.LeetCodeAndBlind75;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = daysToNextHotterDay(temps);
        ArraysUtils.printIntArray(ans);
    }

    private static int[] daysToNextHotterDay(int[] temps) {
        int[] nextHotter = new int[temps.length];
        var mnStk = new Stack<Integer>();

        for(var i = temps.length - 1; i >= 0; i-- ){
            while(!mnStk.isEmpty() && temps[mnStk.peek()] <= temps[i]){
                mnStk.pop();
            }

            if(!mnStk.isEmpty()){
                nextHotter[i] = mnStk.peek() - i;
            }

            mnStk.push(i);
        }

        return nextHotter;
    }
}
