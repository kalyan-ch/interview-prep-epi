package org.wb.Misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TikTokQuestion {

    static class Cell {
        int i; int j; int level;

        public Cell(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }

        @Override
        public String toString() {
            return "i: "+i+" j: "+j+" level: "+level;
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0,6,0,6,0},
                {0,1,0,1,0},
                {0,1,0,1,0},
                {0,1,0,1,0},
                {0,0,0,1,0}
        };

        System.out.println(shortestPathWithLives(0, 0, 4, 4, grid, 2));

        grid = new int[][] {{0,1,0,0,0},{0,6,0,1,0}, {0,0,0,1,0}};
        System.out.println(shortestPathWithLives(0, 0, 2, 4, grid, 1));
        System.out.println(shortestPathWithLives(0, 0, 2, 4, grid, 2));

    }

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int m = 0, n = 0, ei = 0, ej = 0;

    private static int shortestPathWithLives(int si, int sj, int ei, int ej, int[][] grid, int lives) {
        m = grid.length;
        n = grid[0].length;
        TikTokQuestion.ei = ei;
        TikTokQuestion.ej = ej;

        boolean[][] seen = new boolean[m][n];
        LinkedList<Integer> lifes = new LinkedList<>();
        for (int i = 0; i < lives; i++) {
            lifes.add(1);
        }
        return dfs(new Cell(si, sj, 0), grid, seen, lifes);
    }

    private static int dfs(Cell c, int[][] grid, boolean[][] seen, LinkedList<Integer> lifes){
        if(c.i == ei && c.j == ej){
            return c.level;
        }

        seen[c.i][c.j] = true;
        int level = Integer.MAX_VALUE;

        for(int[] dir: dirs){
            int nextI = dir[0] + c.i, nextJ = c.j + dir[1];
            if(nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n
                    && !seen[nextI][nextJ] && grid[nextI][nextJ] != 1){
                if(grid[nextI][nextJ] == 6){
                    lifes.removeLast();
                    level = Math.min(level, dfs(new Cell(nextI, nextJ, c.level + 1), grid, seen, lifes));
                    lifes.add(1);
                } else {
                    level = Math.min(level, dfs(new Cell(nextI, nextJ, c.level + 1), grid, seen, lifes));
                }
            }
        }

        return level;
    }
}
