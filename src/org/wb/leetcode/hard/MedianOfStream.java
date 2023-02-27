package org.wb.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfStream {

    //min heap contains larger elements of the data
    private PriorityQueue<Integer> minHeap;
    //max heap contains smaller elements of the data
    private PriorityQueue<Integer> maxHeap;

    public MedianOfStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    // add number to maxHeap first
    // pop it and add to minHeap so we get the largest element
    // if minHeap is larger add the number back to maxHeap
    // so minHeap is never the larger heap
    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.remove());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.remove());
        }
    }

    //in case of odd number of integers
    // max heap contains the extra element and then the median is maxHeap.peek()
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }

        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }

}
