package org.wb.leetcode.hard;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.*;
public class WordSearch2 {
    public static void main(String[] args) {
        char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] words = {"oa","oaa"};

        ArraysUtils.print2dCharArray(board);
        List<String> wordsInBoard = findWords(board, words);
        ArraysUtils.printStrList(wordsInBoard);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        for(String w: words){
            char c = w.charAt(0);
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j] == c){
                        backtrack(board, w, i, j, 1, result);
                    }
                }
            }
        }
        Set<String> set = new HashSet<>(result);
        result.clear();
        result.addAll(set);

        return result;
    }

    static int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    private static void backtrack(char[][] board, String word, int i, int j, int k, List<String> result) {
        if(k == word.length()){
            result.add(word);
            return;
        }

        char c = board[i][j];
        board[i][j] = Character.MIN_VALUE;

        boolean isFound = false;
        for(int[] dir: dirs){
            int nextI = dir[0] + i, nextJ = dir[1] + j;
            if(nextI >= 0 && nextI < board.length
                    && nextJ >= 0 && nextJ < board[i].length
                    && board[nextI][nextJ] != Character.MIN_VALUE
                    && board[nextI][nextJ] == word.charAt(k)){
                backtrack(board, word, nextI, nextJ, k + 1, result);
            }
        }

        board[i][j] = c;
    }
}
