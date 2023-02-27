package org.wb.leetcode.hard;

import java.util.Random;

public class MedianStreamTester {
    public static void main(String[] args) {
        MedianOfStream ms = new MedianOfStream();
        Random rn = new Random();
        for(int i =0; i < 20; i++){
            int num = rn.nextInt(100);
            ms.addNum(num);
            System.out.println(num+" "+ms.findMedian());
        }
    }
}
