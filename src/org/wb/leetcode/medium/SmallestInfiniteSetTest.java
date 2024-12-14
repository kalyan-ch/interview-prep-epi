package org.wb.leetcode.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestInfiniteSetTest {
    public static void main(String[] args) {

        SmallestInfiniteSet sis = new SmallestInfiniteSet();
        sis.addBack(2);
        System.out.println(sis.popSmallest());
        System.out.println(sis.popSmallest());
        System.out.println(sis.popSmallest());
        sis.addBack(1);
        System.out.println(sis.popSmallest());
        System.out.println(sis.popSmallest());
        System.out.println(sis.popSmallest());

    }
}
