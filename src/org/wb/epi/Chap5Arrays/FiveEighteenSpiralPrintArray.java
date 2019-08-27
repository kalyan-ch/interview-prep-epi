package org.wb.epi.Chap5Arrays;

public class FiveEighteenSpiralPrintArray {

    public static void main(String[] args) {
        int[][] matrix = {
                {2,3,4,5},
                {6,7,8,9},
                {1,2,3,4},
                {5,6,7,8}
        };

        spiralInPrintArray(matrix);

    }

    private static void spiralInPrintArray(int[][] matrix) {
        int n = matrix.length, row = 0, col = 0, dir = 0;
        int[][] shift = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int i = 0; i < n*n; i++){
            System.out.print(matrix[row][col]+ " ");
            matrix[row][col] = 0;

            int nextRow = shift[dir][0] + row, nextCol = shift[dir][1] + col;

            if(nextRow < 0 || nextCol < 0 || nextCol > n-1 || nextRow > n-1 || matrix[nextRow][nextCol] == 0){
                dir = (dir+1) % 4;
                nextRow = shift[dir][0] + row;
                nextCol = shift[dir][1] + col;
            }
            row = nextRow;
            col = nextCol;
        }

    }

}
