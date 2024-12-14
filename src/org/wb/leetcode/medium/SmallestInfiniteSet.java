package org.wb.leetcode.medium;

import java.util.TreeSet;

public class SmallestInfiniteSet {
    TreeSet<Integer> numSet;
    int small = 1;

    public SmallestInfiniteSet() {
        numSet = new TreeSet<>();
    }

    public int popSmallest() {
        if(numSet.isEmpty()) {
            return small++;
        } else {
            int low = numSet.first();
            numSet.remove(low);
            return low;
        }
    }

    public void addBack(int num) {
        if(num < small) {
            numSet.add(num);
        }
    }
}
