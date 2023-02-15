package org.wb.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int size = 0;
    double sum = 0;
    Queue<Integer> q;

    public MovingAverage(int size) {
        this.size = size;
        q = new LinkedList<>();
    }

    public double next(int val) {

        int removedItem = 0;

        q.add(val);
        if(q.size() > size){
            removedItem = q.remove();
        }

        int numItems = q.size() < size ? q.size() : size;

        sum = sum - removedItem + val;

        return sum / (1.0 * numItems);
    }
}
