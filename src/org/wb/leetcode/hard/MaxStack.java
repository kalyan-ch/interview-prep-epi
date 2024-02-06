package org.wb.leetcode.hard;

import java.util.*;

public class MaxStack {

    private final List<Integer> stk;
    private final TreeMap<Integer, List<Integer>> maxStkMap;
    private int tail;

    public MaxStack() {
        stk = new Stack<>();
        maxStkMap = new TreeMap<>();
        tail = 0;
    }

    public void push(int x) {
        stk.add(x);

        List<Integer> indices = maxStkMap.getOrDefault(x, new ArrayList<>());
        indices.add(tail);
        maxStkMap.put(x, indices);

        tail++;
    }

    public int pop() {
        if(tail == 0) {
            return -1;
        }

        int top = stk.get(--tail);

        if (top == maxStkMap.lastKey()) {
            updateMapPop(top);
        }

        return top;
    }

    public int top() {
        if(tail == 0) {
            return -1;
        }

        return stk.get(tail - 1);
    }

    public int peekMax() {
        if(maxStkMap.isEmpty()) {
            return -1;
        }

        return maxStkMap.lastKey();
    }

    public int popMax() {
        if(maxStkMap.isEmpty()) {
            return -1;
        }

        int top = maxStkMap.lastKey();
        List<Integer> indices = maxStkMap.get(top);
        int lastIdx = indices.get(indices.size() - 1);


        // remove from stack

        for (int i = lastIdx + 1; i < tail; i++) {
            stk.set(i - 1, stk.get(i));
        }

        tail--;

        updateMapPop(top);

        return top;
    }

    private void updateMapPop(int top) {
        List<Integer> indices = maxStkMap.get(top);
        indices.remove(indices.size() - 1);
        maxStkMap.put(top, indices);
        if(indices.isEmpty()) {
            maxStkMap.remove(top);
        }
    }
}
