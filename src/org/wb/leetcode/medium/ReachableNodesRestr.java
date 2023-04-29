package org.wb.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class ReachableNodesRestr {
    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{0,5},{0,4},{3,2},{6,5}};
        int[] restricted = {4, 2, 1};
        int numNodes = reachableNodes(7, edges, restricted);
        System.out.println(numNodes);
    }

    private static int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> restrSet = Arrays.stream(restricted).boxed().collect(Collectors.toSet());
        int result = 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] e: edges){
            addNodeToGraph(e[0], e[1], graph);
            addNodeToGraph(e[1], e[0], graph);
        }

        dfs(0, graph, seen, restrSet);

        return seen.size();
    }

    private static void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> seen, Set<Integer> restricted) {
        seen.add(node);

        List<Integer> children = graph.get(node);
        for(int vertice: children) {
            if(!seen.contains(vertice) && !restricted.contains(vertice)) {
                dfs(vertice, graph, seen, restricted);
            }
        }
    }

    private static void addNodeToGraph(int i, int j, Map<Integer, List<Integer>> graph){
        List<Integer> children = graph.getOrDefault(i, new ArrayList<>());
        children.add(j);
        graph.put(i, children);
    }
}
