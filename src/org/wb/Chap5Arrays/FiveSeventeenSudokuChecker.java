package org.wb.Chap5Arrays;

import java.util.HashMap;
import java.util.Map;

public class FiveSeventeenSudokuChecker {

    public static void main(String[] args) {
        int[][] sudokuGrid = {
                {1,0,0, 3,0,2, 5,9,6},
                {0,5,0, 0,6,0, 0,0,8},
                {0,0,0, 0,0,5, 0,2,0},

                {9,0,3, 2,0,0, 6,7,5},
                {0,0,6, 0,9,0, 4,0,0},
                {8,2,7, 0,0,4, 3,0,9},

                {0,8,0, 5,0,0, 0,0,0},
                {7,0,0, 0,2,0, 0,3,0},
                {6,3,0, 9,0,7, 0,0,4}
        };

        ArraysUtils.print2dArray(sudokuGrid);

        System.out.println(isSudokuValid(sudokuGrid));
    }

    private static boolean isSudokuValid(int[][] sudokuGrid) {
        return areRowsValid(sudokuGrid) && areColumnsValid(sudokuGrid) && are3x3GridsValid(sudokuGrid);
    }

    private static boolean are3x3GridsValid(int[][] sudokuGrid) {
        int regionSize = (int)(Math.sqrt(sudokuGrid.length));
        for(int i = 0; i < sudokuGrid.length; i += regionSize){
            for(int j = 0; j< sudokuGrid[i].length; j += regionSize){
                int[] grid = getGrid(sudokuGrid, i, j, regionSize);
                if(!isRowValid(grid))
                    return false;
            }
        }
        return true;
    }

    private static int[] getGrid(int[][] sudokuGrid, int i, int j, int regionSize) {
        int[] grid = {0,0,0,0,0,0,0,0,0};
        int k = 0;
        for(int p = i; p < i+regionSize; p++){
            for(int q = j; q < j+regionSize; q++){
                grid[k++] = sudokuGrid[p][q];
            }
        }
        return grid;
    }

    private static boolean areColumnsValid(int[][] sudokuGrid) {
        for(int j = 0; j < sudokuGrid[0].length; j++){
            int[] column = {0,0,0,0,0,0,0,0,0};
            for(int i = 0; i < sudokuGrid.length; i++){
                column[i] = sudokuGrid[i][j];
            }
            if(!isRowValid(column))
                return false;
        }
        return true;
    }

    private static boolean areRowsValid(int[][] sudokuGrid) {
        for(int[] row: sudokuGrid){
            if(!isRowValid(row))
                return false;
        }
        return true;
    }

    private static boolean isRowValid(int[] nums) {
        Map<Integer, Integer> dupMap = new HashMap<>();
        for(int n: nums){
            if( n != 0 ){
                if(dupMap.getOrDefault(n, 0) != 0)
                    return false;
                dupMap.put(n, 1);
            }
        }
        return true;
    }

}
