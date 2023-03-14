package org.wb.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class TimeEveryoneFriends {
    public static void main(String[] args) {
        int[][] logs = {{20190101,0,1},{20190104,3,4},{20190107,2,3},
                {20190211,1,5},{20190224,2,4},{20190301,0,3},
                {20190312,1,2},{20190322,4,5}};
        System.out.println(earliestAcq(logs, 6));

        logs = new int[][]{{9,3,0},{0,2,1},{8,0,1},{1,3,2},{2,2,0},{3,3,1}};
        System.out.println(earliestAcq(logs, 4));

    }

    public static int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        UnionFind uf = new UnionFind(n);

        int groups = n;
        for(int[] log: logs){
            int time = log[0];
            if(uf.union(log[1], log[2])){
                groups--;
            }

            if(groups == 1){
                return time;
            }
        }

        return -1;
    }


}
