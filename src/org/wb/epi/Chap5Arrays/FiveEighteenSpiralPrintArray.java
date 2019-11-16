package org.wb.epi.Chap5Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FiveEighteenSpiralPrintArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {2,3,4,5},
                {6,7,8,9},
                {1,2,3,4},
                {5,6,7,8}
        };
        spiralInPrintArray(matrix);
        List<List<Integer>> matrix1 = storeNumbersSpirally(5);

        for(List<Integer> row: matrix1){
            ArraysUtils.printIntList(row);
        }

    }

    private static void spiralInPrintArray(int[][] matrix) {
        int n = matrix.length, row = 0, col = 0, dir = 0;
        int[][] shift = {{0,1},{1,0},{0,-1},{-1,0}}; // directions for right, down, left and up in order

        for(int i = 0; i < n*n; i++){
            System.out.print(matrix[row][col]+ " ");
            matrix[row][col] = 0;

            int nextRow = shift[dir][0] + row, nextCol = shift[dir][1] + col;
            // we've hit the limit and need to change the direction to the next one
            if(nextRow < 0 || nextCol < 0 || nextCol > n-1 || nextRow > n-1 || matrix[nextRow][nextCol] == 0){
                dir = (dir+1) % 4; // change direction to left
                nextRow = shift[dir][0] + row;
                nextCol = shift[dir][1] + col;
            }
            row = nextRow;
            col = nextCol;
        }
        System.out.println();
    }

    private static List<List<Integer>> storeNumbersSpirally(int d){
        List<List<Integer>> resultMatrix = new ArrayList<>();
        int[][] shift = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0, dir = 0;
        for(int i = 0; i < d; i++){
            resultMatrix.add(new ArrayList<>(Collections.nCopies(d, 0)));
        }

        for(int i = 1; i <= d*d; i++){
            resultMatrix.get(row).set(col, i);

            int nextRow = row + shift[dir][0], nextCol = col + shift[dir][1];
            if(nextRow < 0 || nextCol < 0 || nextRow == d || nextCol == d || resultMatrix.get(nextRow).get(nextCol) != 0){
                dir = (dir+1)%4;
                nextRow = row + shift[dir][0];
                nextCol = col + shift[dir][1];
            }
            row = nextRow;
            col = nextCol;
        }

        return resultMatrix;
    }

}
