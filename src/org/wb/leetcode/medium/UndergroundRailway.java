package org.wb.leetcode.medium;

import java.util.*;

public class UndergroundRailway {
    Map<String, Map<Integer, Integer>> checkInMap;
    Map<String, Map<Integer, Integer>> checkOutMap;

    public UndergroundRailway() {
        checkInMap = new HashMap<>();
        checkOutMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        Map<Integer, Integer> idMap = checkInMap.getOrDefault(stationName, new HashMap<>());
        idMap.put(id, t);
        checkInMap.put(stationName, idMap);
    }

    public void checkOut(int id, String stationName, int t) {
        Map<Integer, Integer> idMap = checkOutMap.getOrDefault(stationName, new HashMap<>());
        idMap.put(id, t);
        checkOutMap.put(stationName, idMap);
    }

    public double getAverageTime(String startStation, String endStation) {
        Map<Integer, Integer> inIdMap = checkInMap.get(startStation);
        Map<Integer, Integer> outIdMap = checkOutMap.get(endStation);

        int diffs = 0;
        int count = 0;
        for(int id: inIdMap.keySet()){
            if(outIdMap.containsKey(id)){
                diffs += Math.abs(inIdMap.get(id) - outIdMap.get(id));
                count++;
            }
        }

        return diffs / (1.0 * count);
    }
}
