package org.wb.leetcode.interview150.arraysAndStrings;

public class InsertDeleteGetRandom {
    public static void main(String[] args) {
        RandomizedSet rSet = new RandomizedSet();
        rSet.insert(0);
        rSet.insert(1);
        rSet.remove(0);
        rSet.insert(2);
        rSet.remove(1);
        System.out.println(rSet.getRandom());
    }
}
