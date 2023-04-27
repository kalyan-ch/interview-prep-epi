package org.wb.leetcode.medium;

public class TicTacToeTest {
    public static void main(String[] args) {
        TicTacToe tc = new TicTacToe(5);
        System.out.println(tc.move(1,2,2));
        System.out.println(tc.move(3,0,1));
        System.out.println(tc.move(2,2,2));
        System.out.println(tc.move(1,0,1));
        System.out.println(tc.move(2,1,2));
        System.out.println(tc.move(4,4,1));
        System.out.println(tc.move(0,3,2));
        System.out.println(tc.move(0,0,1));
        System.out.println(tc.move(0,1,2));
        System.out.println(tc.move(2,3,1));
        System.out.println(tc.move(1,1,2));
        System.out.println(tc.move(2,4,1));
        System.out.println(tc.move(4,0,2));
        System.out.println(tc.move(3,4,1));
        System.out.println(tc.move(0,2,2));
        System.out.println(tc.move(1,3,1));
        System.out.println(tc.move(3,1,2));
        System.out.println(tc.move(4,1,1));
        System.out.println(tc.move(2,0,2));
        System.out.println(tc.move(3,3,1));
        System.out.println(tc.move(4,2,2));
        System.out.println(tc.move(4,3,1));
        System.out.println(tc.move(3,2,2));
    }
}
