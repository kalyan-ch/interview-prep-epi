package org.wb.leetcode.interview150.graphs;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.*;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] board = {
                {'O','X','X','X','X','O','O','X','O','X','X','X','X','X','X','O','O','X','X','O'},
                {'O','O','O','O','O','O','X','O','X','O','X','O','O','X','X','O','O','O','X','O'},
                {'O','X','O','X','O','X','O','X','O','O','X','X','X','O','O','O','O','O','O','X'},
                {'X','O','O','X','X','X','X','X','O','X','O','O','O','O','X','O','X','O','X','O'},
                {'O','X','O','O','O','O','X','O','O','O','O','X','O','O','X','O','X','X','X','O'},
                {'O','O','O','O','O','O','O','X','O','X','X','O','O','X','X','O','O','X','O','X'},
                {'O','O','X','X','X','X','O','X','X','X','X','O','O','O','X','O','X','O','X','X'},
                {'X','X','X','X','O','O','X','O','X','O','O','O','O','O','O','X','X','X','O','X'},
                {'X','O','O','O','X','X','O','O','X','O','X','X','O','O','O','X','O','O','O','O'},
                {'X','O','O','X','O','X','O','X','O','O','X','X','X','O','O','O','O','O','X','O'},
                {'O','O','O','X','O','O','X','O','O','O','O','O','O','X','O','X','O','O','X','X'},
                {'O','X','O','O','X','X','X','O','X','X','X','O','O','O','X','O','X','O','O','O'},
                {'X','X','X','O','X','X','O','X','O','X','O','X','X','O','O','O','X','O','O','O'},
                {'O','X','X','O','X','O','O','X','X','O','X','X','O','X','X','O','X','X','O','O'},
                {'O','X','X','O','O','X','O','O','O','X','O','X','O','O','O','O','O','O','X','X'},
                {'O','O','X','O','O','O','X','X','O','X','X','X','X','O','X','O','X','O','X','O'},
                {'X','O','O','O','X','O','X','O','X','O','O','O','O','X','X','O','O','O','O','O'},
                {'X','O','O','X','X','O','O','X','X','O','O','O','X','O','O','O','X','X','X','O'},
                {'O','X','O','X','X','O','O','O','X','X','O','O','X','X','X','O','O','X','X','O'},
                {'O','O','X','O','X','O','O','O','O','O','O','O','O','X','O','X','O','O','X','O'}};


        ArraysUtils.print2dCharArray(board);
        System.out.println();
        System.out.println();
        solve(board);
        ArraysUtils.print2dCharArray(board);

        char[][] expected = {
                {'O','X','X','X','X','O','O','X','O','X','X','X','X','X','X','O','O','X','X','O'},
                {'O','O','O','O','O','O','X','X','X','O','X','X','X','X','X','O','O','O','X','O'},
                {'O','X','O','X','O','X','X','X','O','O','X','X','X','O','O','O','O','O','O','X'},
                {'X','O','O','X','X','X','X','X','O','X','O','O','O','O','X','O','X','O','X','O'},
                {'O','X','O','O','O','O','X','O','O','O','O','X','O','O','X','O','X','X','X','O'},
                {'O','O','O','O','O','O','O','X','O','X','X','O','O','X','X','O','O','X','X','X'},
                {'O','O','X','X','X','X','O','X','X','X','X','O','O','O','X','O','X','X','X','X'},
                {'X','X','X','X','X','X','X','X','X','O','O','O','O','O','O','X','X','X','O','X'},
                {'X','O','O','O','X','X','X','X','X','O','X','X','O','O','O','X','O','O','O','O'},
                {'X','O','O','X','X','X','X','X','O','O','X','X','X','O','O','O','O','O','X','O'},
                {'O','O','O','X','X','X','X','O','O','O','O','O','O','X','O','X','O','O','X','X'},
                {'O','X','O','O','X','X','X','O','X','X','X','O','O','O','X','O','X','O','O','O'},
                {'X','X','X','O','X','X','X','X','X','X','X','X','X','O','O','O','X','O','O','O'},
                {'O','X','X','O','X','X','X','X','X','X','X','X','O','X','X','O','X','X','O','O'},
                {'O','X','X','O','O','X','X','X','X','X','X','X','O','O','O','O','O','O','X','X'},
                {'O','O','X','O','O','O','X','X','X','X','X','X','X','O','X','O','X','O','X','O'},
                {'X','O','O','O','X','O','X','X','X','O','O','O','O','X','X','O','O','O','O','O'},
                {'X','O','O','X','X','O','O','X','X','O','O','O','X','O','O','O','X','X','X','O'},
                {'O','X','O','X','X','O','O','O','X','X','O','O','X','X','X','O','O','X','X','O'},
                {'O','O','X','O','X','O','O','O','O','O','O','O','O','X','O','X','O','O','X','O'}};


        System.out.println();
        System.out.println();
        ArraysUtils.print2dCharArray(expected);
    }

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n, m;

    public static void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        int count = 0;

        List<List<Integer>> indicesToCapture = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O') {
                    if(isSurrounded(i, j, board)) {
                        indicesToCapture.add(Arrays.asList(i, j));
                    }
                }
            }
        }

        for(List<Integer> indices: indicesToCapture) {
            capture(indices.get(0), indices.get(1), board);
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'Y') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void capture(int i, int j, char[][] board) {
        if(inValidDims(i, j) || board[i][j] == 'X') {
            return;
        }

        board[i][j] = 'X';

        for(int[] dir: dirs) {
            capture(i + dir[0], j + dir[1], board);
        }
    }

    private static boolean isSurrounded(int i , int j, char[][] board ) {

        if(board[i][j] == 'X') {
            return true;
        }

        board[i][j] = 'Y';
        boolean[] allDirs = {true, true, true, true};

        for(int k = 0; k < allDirs.length; k++) {
            int nextI = i + dirs[k][0], nextJ = j + dirs[k][1];

            if (inValidDims(nextI, nextJ)) {
                allDirs[k] = false;
            } else if(board[nextI][nextJ] != 'Y') {
                allDirs[k] = isSurrounded(nextI, nextJ, board);
            }
        }

        for(boolean dir: allDirs) {
            if(!dir) {
                return false;
            }
        }
        return true;
    }

    private static boolean inValidDims(int i, int j) {
        return (i < 0 || j < 0 || i >= m || j >= n);
    }
}
