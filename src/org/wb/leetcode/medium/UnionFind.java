package org.wb.leetcode.medium;

public class UnionFind {
    int[] parents;
    int[] rank;

    public UnionFind(int n){
        parents = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
            rank[i] = 1;
        }
    }

    // joins two vertices to a union
    public boolean union(int i, int j){
        int rootI = find(i);
        int rootJ = find(j);

        if(rootI == rootJ){
            return false;
        }

        if(rank[rootI] > rank[rootJ]){
            parents[rootJ] = rootI;
        } else if (rank[rootJ] > rank[rootI]){
            parents[rootI] = rootJ;
        } else {
            parents[rootJ] = rootI;
            rank[rootI]++;
        }

        return true;
    }

    // returns the root of the union
    public int find(int i){
        while(i != parents[i]){
            i = parents[i];
        }

        return i;
    }

}
