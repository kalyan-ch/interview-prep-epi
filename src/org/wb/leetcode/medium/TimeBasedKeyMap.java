package org.wb.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyMap {
    Map<String, TreeMap<Integer, String>> data;
    int prevTime = 0;

    public TimeBasedKeyMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> timeMap = data.getOrDefault(key, new TreeMap<>());
        timeMap.put(timestamp, value);
        data.put(key, timeMap);
        prevTime = timestamp;
    }

    public String get(String key, int timestamp) {
        if(!data.containsKey(key)){
            return "";
        }

        TreeMap<Integer, String> timeMap = data.get(key);
        Integer time = timeMap.floorKey(timestamp);

        if(time == null){
            return "";
        }

        return timeMap.get(time);
    }
}
