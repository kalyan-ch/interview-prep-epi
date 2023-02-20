package org.wb;

import org.wb.epi.Chap5Arrays.ArraysUtils;

public class Main {

    public static void main(String[] args) {
       char[][] maze = {{'+','.','+','+','+','+','+'},{'+','.','+','.','.','.','+'},{'+','.','+','.','+','.','+'},{'+','.','.','.','.','.','+'},{'+','+','+','+','.','+','.'}};

        ArraysUtils.print2dCharArray(maze);
    }
}
