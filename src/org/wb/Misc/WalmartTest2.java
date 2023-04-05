package org.wb.Misc;

import java.util.*;

public class WalmartTest2 {
    public static void main(String[] args) {
        /*
            ABC is a growing tech company with many employees.
            Each employee has:
            • An EID number (Employee ID)
            • A CRC value (Cumulative Report Count)

            An employee's CRC is the total number of direct and indirect employees who report to them plus 1 (for themself). An employee with no reports has a CRC of 1.

            Given this sample direct report map of EIDs, what is the CRC for each employee?

            {
              1: [2, 3],
              2: [4, 5],
              3: [],
              4: [],
              5: [],
            }
         */
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, new ArrayList<>());
        graph.put(4, new ArrayList<>());
        graph.put(5, new ArrayList<>());

        Map<Integer, Integer> crcMap = findCRC(graph);
        for(int e: crcMap.keySet()){
            System.out.println(e+" "+crcMap.get(e));
        }
    }

    private static Map<Integer, Integer> findCRC(Map<Integer, List<Integer>> graph) {
        Map<Integer, Integer> result = new HashMap<>();

        for(int e : graph.keySet()){
            if(graph.get(e).size() == 0) {
                result.put(e, 1);
            }
        }


        for(int e : graph.keySet()){
            int crc = 0;
            if(graph.get(e).size() != 0){
                crc += dfs(e, graph, result);
                result.put(e, crc);
            }
        }

        return result;
    }

    private static int dfs(int empl, Map<Integer, List<Integer>> graph, Map<Integer, Integer> result){
        if(result.containsKey(empl)){
            return result.get(empl);
        }

        List<Integer> children = graph.get(empl);
        int crc = 1;
        for(int c: children){
            crc += dfs(c, graph, result);
        }

        return crc;
    }


}
