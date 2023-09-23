package org.wb.leetcode.easy;

public class IslandPerimeter {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grid2 = {{1, 0}};

        System.out.println(islandPerimeter(grid));
        System.out.println(islandPerimeter(grid2));
    }
    public static int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    return dfs(i, j, grid);
                }
            }
        }
        return 0;
    }

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int dfs(int i, int j, int[][] grid) {
        grid[i][j] = 2;

        int perimeter = 0;
        for(int[] dir: dirs) {
            int nextI = i + dir[0], nextJ = j + dir[1];

            if(!isValid(nextI, nextJ, grid)) {
                perimeter += 1;
            } else {
                if(grid[nextI][nextJ] != 2) {
                    perimeter += dfs(nextI, nextJ, grid);
                }
            }
        }

        return perimeter;
    }

    private static boolean isValid(int i, int j, int[][] grid) {
        return !(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0);
    }
}
