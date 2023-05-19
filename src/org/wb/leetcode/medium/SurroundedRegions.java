package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        solve(board);
        ArraysUtils.print2dCharArray(board);
    }

    static int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static int m, n;
    public static void solve(char[][] board) {
        m = board.length; n = board[0].length;

        for(int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if(board[i][j] == 'O') {
                    boolean[][] seen = new boolean[m][n];
                    if(isSurrounded(board, i, j, seen)) {
                        fillWithX(board, i, j);
                    }
                }
            }
        }
    }

    private static boolean isSurrounded(char[][] board, int i, int j, boolean[][] seen) {
        boolean result = true;
        seen[i][j] = true;

        for(int[] dir: dirs) {
            int r = i + dir[0], c = j + dir[1];
            if(r >= m || r < 0 || c >= n || c < 0){
                return false;
            }
            if(board[r][c] == 'O' && !seen[r][c]){
                result &= isSurrounded(board, r, c, seen);
            }
        }

        return result;
    }

    private static void fillWithX(char[][] board, int i, int j) {
        board[i][j] = 'X';

        for(int[] dir: dirs) {
            int r = i + dir[0], c = j + dir[1];
            if(r < m && r >= 0 && c < n && c >= 0 && board[r][c] == 'O'){
                fillWithX(board, r, c);
            }
        }
    }
}
