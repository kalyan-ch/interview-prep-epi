package org.wb.leetcode.hard;

import java.util.*;

public class NQueens {

    public static void main(String[] args) {
        List<List<String>> sols = solveNQueens(8);
        List<String> sol = sols.get(0);

        for(String s: sol){
            for(int i = 0; i < s.length(); i++){
                System.out.print("["+s.charAt(i)+"]");
            }
            System.out.println();
        }

        // check if queen is being attacked by existing queens
        // one row can't contain more than one queen - i
        // one col can't contain more than one queen - j
        // diagonal can't have more than one queen - i-j
        // anti-diagonal can't have more than one queen - i+j
    }

    private static int size;
    private static char[][] board;
    private static List<List<String>> result;

    public static List<List<String>> solveNQueens(int n) {
        if (n == 1) {
            return Arrays.asList(Arrays.asList("Q"));
        }

        size = n;
        board = new char[n][n];
        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        placeQueen(0, new HashSet<>(), new HashSet<>(), new HashSet<>());

        return result;
    }

    private static void placeQueen (int row, Set<Integer > cols, Set <Integer> ds, Set <Integer> antiDs){
        if (row == size) {
            result.add(getSol(board));
        }

        for (int col = 0; col < size; col++) {
            int currD = row - col;
            int currAntiD = row + col;

            if (cols.contains(col) || ds.contains(currD) || antiDs.contains(currAntiD)) {
                continue;
            }

            board[row][col] = 'Q';
            cols.add(col);
            ds.add(currD);
            antiDs.add(currAntiD);

            placeQueen(row + 1, cols, ds, antiDs);

            board[row][col] = '.';
            cols.remove(col);
            ds.remove(currD);
            antiDs.remove(currAntiD);
        }
    }

    private static List<String> getSol ( char[][] board){
        List<String> sol = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String s = String.valueOf(board[i]);
            sol.add(s);
        }

        return sol;
    }

}
