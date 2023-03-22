package org.wb.leetcode.medium;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {
    private Map<Integer, Integer> eventCount;
    public MyCalendar() {
        eventCount = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        eventCount.put(start, eventCount.getOrDefault(start, 0) + 1);
        eventCount.put(end, eventCount.getOrDefault(end, 0) - 1);

        int totalEvents = 0;
        for(int key: eventCount.keySet()){
            totalEvents += eventCount.get(key);
            if(totalEvents > 1){
                eventCount.put(start, eventCount.getOrDefault(start, 0) - 1);
                eventCount.put(end, eventCount.getOrDefault(end, 0) + 1);
                return false;
            }
        }

        return true;
    }
}
