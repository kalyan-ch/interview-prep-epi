package org.wb.leetcode.medium;

public class LargestIslandAreaGrid {
    static int maxArea = 0, m = 0, n = 0;
    static int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(largestIslandArea(grid));
    }

    private static int largestIslandArea(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    traverse(grid, 1, i, j);
                }
            }
        }

        return maxArea;
    }

    private static void traverse(int[][] grid, int area, int i, int j){
        grid[i][j] = 2;
        maxArea = Math.max(maxArea, ++area);

        for(int[] d: dir){
            int nextI = i + d[0], nextJ = j + d[1];
            if(nextI < m && nextI >= 0 && nextJ < n && nextJ >= 0
                    && grid[nextI][nextJ] != 0 && grid[nextI][nextJ] != 2){
                traverse(grid, area, nextI, nextJ);
            }
        }
    }

}
