package org.wb.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageTest {

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(800);
        int[] inputs = {15413, 9870, -21189, 4193, 3831, 13087, -27212, 321, 2214, -25570, -31228, 30659, -29168, 7486, -18886};

        for (int i : inputs) {
            System.out.println(movingAverage.next(i));
        }
    }
}
