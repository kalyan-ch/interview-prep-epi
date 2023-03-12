package org.wb.leetcode.medium;

import java.util.*;

public class LeaderBoard {
    List<Integer> sortedScores;
    Map<Integer, Integer> playerMap;

    public LeaderBoard() {
        playerMap = new HashMap<>();
        sortedScores = new LinkedList<>();
    }

    public void addScore(int playerId, int score) {
        int sc = playerMap.getOrDefault(playerId, 0);
        playerMap.put(playerId, sc + score);

        if(!sortedScores.isEmpty()){
            int idx = 0;

            if(sc == 0){
                while(idx < sortedScores.size()){
                    if(sortedScores.get(idx) > score){
                        sortedScores.add(idx, score);
                        break;
                    }
                    idx++;
                }

                if(idx == sortedScores.size()){
                    sortedScores.add(score);
                }

            } else {
                idx = binarySearch(sc);
                sortedScores.set(idx, sc + score);
                Collections.sort(sortedScores);
            }
        } else {
            sortedScores.add(score);
        }
    }

    public int top(int K) {
        int topSum = 0;
        for(int i = sortedScores.size() - 1; i > sortedScores.size() - 1 - K; i--){
            topSum += sortedScores.get(i);
        }

        return topSum;
    }

    public void reset(int playerId) {
        int score = playerMap.get(playerId);
        playerMap.remove(playerId);

        int idx = binarySearch(score);
        sortedScores.remove(idx);
    }

    private int binarySearch(int val){
        int l = 0, r = sortedScores.size() - 1;

        while(l <= r){
            int m = l + (r - l) / 2 ;
            if(sortedScores.get(m) == val){
                return m;
            } else if (sortedScores.get(m) > val){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }

}
