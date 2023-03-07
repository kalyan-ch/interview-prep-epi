package org.wb.leetcode.medium;

import java.util.*;

public class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> array;
    int i;

    public RandomizedSet() {
        map = new HashMap<>();
        array = new ArrayList<>();
        i = -1;
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            array.add(val);
            map.put(val, ++i);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        int idx = map.get(val);
        array.set(idx, array.get(i));
        map.put(array.get(i), idx);
        array.remove(i);

        map.remove(val);
        i--;
        return true;
    }

    public int getRandom() {
        Random rn = new Random();
        int randIdx = (i == 0) ? 0 : rn.nextInt(array.size());
        return array.get(randIdx);
    }
}
