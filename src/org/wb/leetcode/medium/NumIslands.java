package org.wb.leetcode.medium;

public class NumIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    for(int[] dir: dirs){
                        int r = i + dir[0], c = j + dir[1];
                        if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){
                            int curr = i * n + j, next = r * n + c;
                            uf.union(curr, next);
                        }
                    }
                }
            }
        }

        return uf.count;
    }
}
