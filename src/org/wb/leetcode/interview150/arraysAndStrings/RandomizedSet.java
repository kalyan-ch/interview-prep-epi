package org.wb.leetcode.interview150.arraysAndStrings;

import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> dataMap;
    private List<Integer> dataList;

    public RandomizedSet() {
        dataMap = new HashMap<>();
        dataList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(dataMap.containsKey(val)){
            return false;
        }

        dataMap.put(val, dataList.size());
        dataList.add(val);
        return true;
    }

    public boolean remove(int val) {
        if(!dataMap.containsKey(val)){
            return false;
        }

        int index = dataMap.get(val);
        int lastIdx = dataList.size() - 1;
        int lastNum = dataList.get(lastIdx);
        // overwrite the removing idx with last element
        dataList.set(index, lastNum);
        dataMap.put(lastNum, index);
        // remove last element
        dataList.remove(lastIdx);
        // remove the val from map
        dataMap.remove(val);
        return true;
    }

    public int getRandom() {

        Random rand = new Random();

        return dataList.get(rand.nextInt(dataList.size()));
    }
}
