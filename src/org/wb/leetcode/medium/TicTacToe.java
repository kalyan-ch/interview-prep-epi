package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class TicTacToe {

    int[][] board;
    int n;
    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        return checkWinner(row, col, player);
    }

    private int checkWinner(int r, int c, int p){
        // check row - r
        if(check(r, p, true)){
            return p;
        }


        // check col - c
        if(check(c, p, false)){
            return p;
        }

        // check diagonals from cell board[r][c]
        if(checkD(r, c, p, true)){
            return p;
        }

        if(checkD(r, c, p, false)){
            return p;
        }

        return 0;
    }

    private boolean check(int r, int p, boolean isRow){
        for(int i = 0; i < n; i++){
            int num = isRow ? board[r][i] : board[i][r];
            if(num != p){
                return false;
            }
        }

        return true;
    }

    private boolean checkD(int r, int c, int p, boolean isMainD){
        for(int i = 0; i < n; i++){
            int num = isMainD ? board[i][i] : board[i][n - i - 1];
            if(num != p){
                return false;
            }
        }

        return true;
    }


}
