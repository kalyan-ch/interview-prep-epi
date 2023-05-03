package org.wb.leetcode.medium;

import java.util.Arrays;

public class CircularQueue {
    int size, head, tail;
    int[] arr;

    public CircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);

        size = k;
        head = -1; tail = -1;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }

        if (tail < 0) {
            tail = 0;
            head = 0;
        } else {
            tail++;
            tail %= size;
        }

        arr[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        arr[head] = -1;

        if(head == tail){
            head = tail = -1;
        } else {
            head++;
            head %= size;
        }

        return true;
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }

        return arr[head];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return arr[tail];
    }

    public boolean isEmpty() {
        return head < 0;
    }

    public boolean isFull() {
        return (head - tail == 1) || (head == 0 && tail == size - 1);
    }
}
