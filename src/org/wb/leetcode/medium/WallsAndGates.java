package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public static void main(String[] args) {
        int[][] grid = {
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };

        fillGridWithDist(grid);
        ArraysUtils.print2dArray(grid);
    }

    static class Cell {
        int i, j, level;

        public Cell(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }

    static int[][] dirs = {{0, -1}, {1, 0}, {-1, 0}, {0, 1}};
    static int m, n;
    private static void fillGridWithDist(int[][] rooms) {
        int INF = Integer.MAX_VALUE;
        m = rooms.length; n = rooms[0].length;
        boolean[][] seen = new boolean[m][n];
        Queue<Cell> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(rooms[i][j] == 0){
                    q.add(new Cell(i, j, 0));
                }
            }
        }

        while(!q.isEmpty()) {
            Cell c = q.poll();
            seen[c.i][c.j] = true;

            if(rooms[c.i][c.j] != 0){
                rooms[c.i][c.j] = Math.min(rooms[c.i][c.j], c.level);
            }

            for (int[] dir : dirs) {
                int nextI = c.i + dir[0], nextJ = c.j + dir[1];
                if (isValid(nextI, nextJ) && rooms[nextI][nextJ] != -1 && !seen[nextI][nextJ]) {
                    q.add(new Cell(nextI, nextJ, c.level + 1));
                }
            }
        }
    }

    private static boolean isValid(int i, int j){
        return i < m && i >= 0 && j < n && j >= 0;
    }
}
