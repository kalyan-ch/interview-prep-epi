package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.io.File;
import java.util.*;


public class NearestZero {
    public static void main(String[] args) {

        try{
            int[][] matrix = readFile("src/org/wb/leetcode/testfiles/array.txt");
            long millis = System.currentTimeMillis();
            int[][] nearZero = nearestZero(matrix);
            long diff = System.currentTimeMillis() - millis;
            System.out.println(diff);
            //ArraysUtils.print2dArray(nearZero);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static int[][] readFile(String fileName) throws Exception{
        File myObj = new File(fileName);
        Scanner myReader = new Scanner(myObj);
        List<List<Integer>> result = new ArrayList<>();
        while (myReader.hasNextLine()) {
            String s =myReader.nextLine();
            String[] arr = s.split(",");
            result.add(Arrays.asList(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));
        }

        int[][] matrix = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++){
            matrix[i][0] = result.get(i).get(0);
            matrix[i][1] = result.get(i).get(1);
        }
        return matrix;
    }

    static class Key{
        public int i, j, level;
        public Key(int i, int j, int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }

    public static int[][] nearestZero(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int[][] result = new int[m][n];
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Queue<Key> q = new LinkedList<>();
                boolean[][] seen = new boolean[m][n];
                q.add(new Key(i,j, 0));
                while(!q.isEmpty()){
                    Key cell = q.poll();
                    seen[cell.i][cell.j] = true;
                    if(mat[cell.i][cell.j] == 0){
                        result[i][j] = cell.level;
                        break;
                    }

                    for(int[] d: dir){
                        int nextI = cell.i + d[0];
                        int nextJ = cell.j + d[1];
                        if(isValid(nextI, nextJ, m, n) && !seen[nextI][nextJ]){
                            q.add(new Key(nextI, nextJ, cell.level + 1));
                        }
                    }

                }
            }
        }

        return result;
    }

    private static boolean isValid(int i, int j, int m, int n){
        return !(i < 0 || i >= m || j < 0 || j >= n);
    }
}
