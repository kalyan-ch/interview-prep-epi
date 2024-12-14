package org.wb.leetcode.LeetCodeAndBlind75;

public class RecentCounterTest {
    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();

        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
        System.out.println(rc.ping(5001));
    }
}
