package org.wb.leetcode.LeetCodeAndBlind75;

import java.util.LinkedList;

public class Dota2Senate {

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDD"));
    }

    public static String predictPartyVictory(String senate) {
        var radQue = new LinkedList<Integer>();
        var dirQue = new LinkedList<Integer>();
        var n = senate.length();

        for(int i = 0; i < n; i++) {
            if(senate.charAt(i) == 'R') {
                radQue.add(i);
            } else {
                dirQue.add(i);
            }
        }

        while(!radQue.isEmpty() && !dirQue.isEmpty()) {
            int i = radQue.poll(), j = dirQue.poll();
            if(i < j) {
                radQue.add(i + n);
            } else {
                dirQue.add(j + n);
            }
        }

        return radQue.size() > dirQue.size() ? "Radiant" : "Dire";
    }
}
