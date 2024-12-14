package org.wb.leetcode.LeetCodeAndBlind75;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        var head = queue.peek();
        if(t - head > 3000) {
            queue.poll();
        }
        return queue.size();
    }
}
