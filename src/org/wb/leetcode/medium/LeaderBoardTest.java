package org.wb.leetcode.medium;

public class LeaderBoardTest {
    public static void main(String[] args) {
        LeaderBoard lb = new LeaderBoard();
        lb.addScore(1,13);
        lb.addScore(2,93);
        lb.addScore(3,84);
        lb.addScore(4,6);
        lb.addScore(5,89);
        lb.addScore(6,31);
        lb.addScore(7,7);
        lb.addScore(8,1);
        lb.addScore(9,98);
        lb.addScore(10,42);
        System.out.println(lb.top(5));
        lb.reset(1);
        lb.reset(2);
        lb.addScore(3,76);
        lb.addScore(4,68);
        lb.top(1);
        lb.reset(3);
        lb.reset(4);
        lb.addScore(2, 70);
        lb.reset(2);
    }
}
