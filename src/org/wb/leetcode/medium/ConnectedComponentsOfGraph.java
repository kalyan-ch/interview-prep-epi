package org.wb.leetcode.medium;
import java.util.*;

public class ConnectedComponentsOfGraph {

    public static void main(String[] args) {
        int[][] edges = {{0,1},{1,2},{2,3},{3,4}};

        System.out.println(countComponents(5, edges));
    }

    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static boolean[] seen;
    public static int countComponents(int n, int[][] edges) {
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }
        seen = new boolean[n];

        for(int[] e: edges){
            int x = e[0], y = e[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                ans++;
                seen[i] = true;
                dfs(i);
            }
        }
        return ans;
    }

    private static void dfs(int node){
        for(int v: graph.get(node)){
            if(!seen[v]){
                seen[v] = true;
                dfs(v);
            }
        }
    }
}
