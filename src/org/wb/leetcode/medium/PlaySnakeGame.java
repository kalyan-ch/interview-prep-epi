package org.wb.leetcode.medium;

import java.util.Scanner;

public class PlaySnakeGame {
    public static void main(String[] args) {
        SnakeGame sg = new SnakeGame(3, 3,
                new int[][]{{2,0}, {0,0}, {0,2}, {0,1}, {2,2}});
        sg.printBoard();
        String[] directions = {"D","D","R","U","U","L","D","R","R","U","L","L","D"};

        for(int i = 0; i < directions.length; i++){
            System.out.println(sg.move(directions[i]));
            sg.printBoard();
        }
    }
}
