package org.wb.leetcode.medium;

public class CircularQueueTest {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(6);
        System.out.println("enQueue "+cq.enQueue(6));
        System.out.println("Rear "+cq.Rear());
        System.out.println("Rear "+cq.Rear());
        System.out.println("deQueue "+cq.deQueue());
        System.out.println("enQueue "+cq.enQueue(5));
        System.out.println("Rear "+cq.Rear());
        System.out.println("deQueue "+cq.deQueue());
        System.out.println("Front "+cq.Front());
        System.out.println("deQueue "+cq.deQueue());
        System.out.println("deQueue "+cq.deQueue());
        System.out.println("deQueue "+cq.deQueue());
    }
}
