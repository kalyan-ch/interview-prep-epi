package org.wb.leetcode.medium;

public class UnionFind {
    int[] parents;
    int[] rank;
    int count;

    public UnionFind(int n){
        parents = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
            rank[i] = 1;
        }
    }

    public UnionFind(char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        parents = new int[m * n];
        rank = new int[m * n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    parents[i * n + j] = i * n + j;
                    count++;
                }
                rank[i * n + j] = 0;
            }
        }
    }

    // joins two vertices to a union
    public boolean union(int i, int j){
        int rootI = find(i);
        int rootJ = find(j);

        if(rootI == rootJ){
            return false;
        }

        count--;
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
        if(parents[i] != i){
            parents[i] = find(parents[i]);
        }
        return parents[i];
    }

}
