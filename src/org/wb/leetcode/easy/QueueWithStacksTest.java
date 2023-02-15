package org.wb.leetcode.easy;

public class QueueWithStacksTest {
    public static void main(String[] args) {
        QueueWithStacks qs = new QueueWithStacks();
        qs.push(1);
        qs.push(2);
        System.out.println(qs.pop());
        System.out.println(qs.peek());
    }
}
