package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.*;

public class SortDiagonalCells {
    public static void main(String[] args) {
        int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int[][] result = diagonalSort(mat);

        ArraysUtils.print2dArray(result);
    }

    static int[][] matrix;
    static int m, n;

    public static int[][] diagonalSort(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        matrix = mat;
        int[][] result = new int[m][n];


        for(int k = 0; k < n; k++) {
            diagCellSort(0, k);
        }

        for(int k = 0; k < m; k++) {
            diagCellSort(k, 0);
        }


        return matrix;
    }

    private static void diagCellSort(int row, int col) {
        List<Integer> diagCells = new ArrayList<>();
        int i = row, j = col;
        while(i < m && j < n) {
            diagCells.add(matrix[i][j]);
            i++; j++;
        }

        Collections.sort(diagCells);
        Iterator<Integer> diagIter = diagCells.iterator();
        i = row; j = col;
        while(i < m && j < n) {
            matrix[i][j] = diagIter.next();
            i++; j++;
        }
    }
}
