package org.wb.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExit {
    public static void main(String[] args) {
        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        System.out.println(stepsToNearestExit(maze, new int[]{1, 2}));
    }

    static class Key{
        int i;
        int j;
        int step;

        Key(int i, int j, int step){
            this.i = i;
            this.j = j;
            this.step = step;
        }
    }

    static int m, n;
    public static int stepsToNearestExit(char[][] maze, int[] entrance) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        m = maze.length;
        n = maze[0].length;

        boolean[][] seen = new boolean[m][n];
        Queue<Key> q = new LinkedList<>();
        q.add(new Key(entrance[0], entrance[1], 0));
        seen[entrance[0]][entrance[1]] = true;

        while(!q.isEmpty()){
            Key pos = q.poll();
            int i = pos.i, j = pos.j, step = pos.step;

            if(isBorder(i, j) && !(i == entrance[0] && j == entrance[1])){
                return step;
            }
            for(int[] nx: dirs){
                int nextI = i + nx[0], nextJ = j + nx[1];
                if(isValid(maze, nextI, nextJ) && !seen[nextI][nextJ]){
                    seen[nextI][nextJ] = true;
                    q.add(new Key(nextI, nextJ, step+1));
                }
            }
        }
        return -1;
    }


    private static boolean isBorder(int i, int j){
        return (i == 0 || i == m - 1 || j == 0 || j == n - 1);
    }

    private static boolean isValid(char[][] maze, int i, int j){
        return !(i < 0 || i >= m || j < 0 || j >= n || maze[i][j] == '+');
    }
}
