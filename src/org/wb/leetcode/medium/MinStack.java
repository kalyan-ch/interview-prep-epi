package org.wb.leetcode.medium;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> monStk;

    public MinStack() {
        stack = new Stack<>();
        monStk = new Stack<>();
    }

    public void push(int val) {
        if(monStk.isEmpty() || monStk.peek() >= val){
            monStk.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if(stack.peek().equals(monStk.peek())) {
            monStk.pop();
        }

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return monStk.peek();
    }
}
