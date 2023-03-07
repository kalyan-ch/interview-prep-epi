package org.wb.leetcode.medium;

public class RandomizedSetTest {
    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(0));
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(0));
        System.out.println(rs.insert(2));
        System.out.println(rs.remove(1));
        System.out.println(rs.getRandom());
    }
}
