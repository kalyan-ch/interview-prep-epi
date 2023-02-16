package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.*;

public class SnakeGame {
    int[][] food;
    int[][] board;
    int foodCounter = 0;
    int snakeI, snakeJ, snakeLen;
    Queue<String>  snakePath;
    HashSet<String> snakeSet;

    Map<String, List<Integer>> dirMap;

    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        board = new int[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                board[i][j] = 0;
            }
        }

        snakeI = 0;
        snakeJ = 0;
        snakePath = new LinkedList<>();
        snakeSet = new HashSet<>();
        String key = snakeI+","+snakeJ;
        snakePath.add(key);
        snakeSet.add(key);
        snakeLen = 1;

        board[snakeI][snakeJ] = 1;

        getNextFood();

        dirMap = new HashMap<>();
        dirMap.put("U", Arrays.asList(-1, 0));
        dirMap.put("D", Arrays.asList(1, 0));
        dirMap.put("L", Arrays.asList(0, -1));
        dirMap.put("R", Arrays.asList(0, 1));

    }

    public int move(String direction) {
        List<Integer> dir = dirMap.get(direction);
        int nextI = snakeI + dir.get(0), nextJ = snakeJ + dir.get(1);
        String key = nextI+","+nextJ;

        if((nextI > board.length - 1 || nextI < 0) ||
                (nextJ > board[0].length - 1 || nextJ < 0)){
            return -1;
        }

        if(board[nextI][nextJ] == 3){
            foodCounter++;
            snakeLen++;
            getNextFood();
        } else {
            String tail = snakePath.poll();
            snakeSet.remove(tail);
        }

        if(snakeSet.contains(key)){
            return -1;
        }

        snakePath.add(key);
        snakeSet.add(key);

        board[snakeI][snakeJ] = 0;
        board[nextI][nextJ] = 1;

        snakeI = nextI; snakeJ = nextJ;

        return snakeLen - 1;
    }

    private void getNextFood(){
        if(foodCounter < food.length){
            board[food[foodCounter][0]][food[foodCounter][1]] = 3;
        }
    }

    public void printBoard(){
        ArraysUtils.print2dArray(board);
    }
}
