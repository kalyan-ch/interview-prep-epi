package org.wb.neetcodeOneFifty.ArraysHashing;

import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
            {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
            {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
            {'.', '9', '1', '.', '.', '.', '.', '.', '3'},
            {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
            {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };

        char[][] board2 = {
            {'1','2','.','.','3','.','.','.','.'},
            {'4','.','.','5','.','.','.','.','.'},
            {'.','9','8','.','.','.','.','.','3'},
            {'5','.','.','.','6','.','.','.','4'},
            {'.','.','.','8','.','3','.','.','5'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','.','.','.','.','.','2','.','.'},
            {'.','.','.','4','1','9','.','.','8'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(board2));
    }

    public static boolean isValidSudoku(char[][] board) {
        var colMap = new HashMap<Integer, HashSet<Character>>();
        var rowMap = new HashMap<Integer, HashSet<Character>>();
        var gridMap = new HashMap<String, HashSet<Character>>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.'){
                    continue;
                }

                var gridKeySb = new StringBuilder();
                var gridKey = gridKeySb.append(i/3).append(",").append(j/3).toString();

                if (rowMap.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j])
                        || colMap.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j])
                        || gridMap.computeIfAbsent(gridKey, k -> new HashSet<>()).contains(board[i][j])
                ) {
                    return false;
                }

                rowMap.get(i).add(board[i][j]);
                colMap.get(j).add(board[i][j]);
                gridMap.get(gridKey).add(board[i][j]);
            }
        }

        return true;
    }
}
