package org.wb.leetcode.easy;

import java.util.Stack;

public class QueueWithStacks {
    int front;
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueueWithStacks() {
        front = 0;
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if(s1.isEmpty()){
            front = x;
        }
        s1.push(x);
    }

    public int pop() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        int y = s2.pop();
        front = s2.peek();

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

        return y;
    }

    public int peek() {
        return front;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
