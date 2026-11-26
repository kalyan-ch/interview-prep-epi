package org.wb.neetcodeOneFifty.BinarySearch;

public class BinarySearchInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        System.out.println(binarySearch(matrix, 3));
    }

    public static boolean binarySearch(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int low = 0, high = (rows * cols) - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / cols, c = mid % cols;

            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
