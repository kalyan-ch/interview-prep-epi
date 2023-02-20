package org.wb.leetcode.medium;

public class IslandOfMaxArea {

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};

        System.out.println(maxAreaOfIsland(grid));
    }

    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    result = Math.max(result, area);
                }
            }
        }
        return result;

    }

    private static int dfs(int[][] grid, int i, int j){
        if(i >= grid.length || i < 0 || j >= grid[i].length || j < 0 ||
                grid[i][j] == 0 || grid[i][j] == 2){
            return 0;
        }
        int area = 1;

        grid[i][j] = 2;

        for(int k = 0; k < directions.length; k++){
            area += dfs(grid, i + directions[k][0], j + directions[k][1]);
        }

        return area;
    }
}
