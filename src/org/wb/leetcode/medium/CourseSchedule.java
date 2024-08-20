package org.wb.leetcode.medium;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.*;


public class CourseSchedule {

    // topological sort
    public static void main(String[] args) {
        int[][] prereqs = {{0, 1}};
        System.out.println(canFinish(prereqs.length, prereqs));
        int[] order = findOrder(prereqs.length, prereqs);

        ArraysUtils.printIntArray(order);
    }
    static class Node{
        int inDegree = 0;
        List<Integer> nodes = new LinkedList<>();

        @Override
        public String toString(){
            return "inDegree: "+inDegree;
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            return true;
        }

        Map<Integer, Node> graph = new HashMap<>();

        // create graph - map of number to Node
        // record the indegree for each node
        for(int[] edge: prerequisites){
            Node fromC = createOrGetNode(graph, edge[1]);
            Node toC = createOrGetNode(graph, edge[0]);

            // from course has dependency on to course
            // so add an edge
            fromC.nodes.add(edge[0]);
            toC.inDegree++;
        }

        Queue<Integer> noDepCs = new LinkedList<>();

        // get all nodes with 0 in-degree
        for(int c: graph.keySet()){
            if(graph.get(c).inDegree == 0){
                noDepCs.add(c);
            }
        }

        int removedEdges = 0;
        // start traversing the graph with nodes with 0 incoming edges
        // remove all the edges (increment the edges seen)
        while(!noDepCs.isEmpty()){
            int c = noDepCs.poll();

            for(int nc: graph.get(c).nodes){
                Node child = graph.get(nc);
                child.inDegree--;
                removedEdges++;
                if(child.inDegree == 0){
                    noDepCs.add(nc);
                }
            }
        }

        return removedEdges == prerequisites.length;
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0){
            return new int[]{};
        }

        List<Integer> resList = new ArrayList<>();
        Map<Integer, Node> graph = new HashMap<>();

        for(int[] edge: prerequisites){
            Node fromC = createOrGetNode(graph, edge[1]);
            Node toC = createOrGetNode(graph, edge[0]);

            fromC.nodes.add(edge[0]);
            ++toC.inDegree;
        }

        Queue<Integer> noInEdges = new LinkedList<>();
        for(int c: graph.keySet()){
            if(graph.get(c).inDegree == 0){
                noInEdges.add(c);
            }
        }

        int removedEdges = 0;

        while(!noInEdges.isEmpty()){
            int c = noInEdges.poll();
            resList.add(c);
            for(int nextC: graph.get(c).nodes){
                Node child = graph.get(nextC);
                --child.inDegree;
                removedEdges++;

                if(child.inDegree == 0){
                    noInEdges.add(nextC);
                }
            }
        }

        if(removedEdges == prerequisites.length){
            return resList.stream().mapToInt(i->i).toArray();
        }

        return new int[]{};
    }

    private static Node createOrGetNode(Map<Integer, Node> graph, int c){
        Node x = graph.getOrDefault(c, new Node());
        graph.put(c, x);
        return x;
    }
}
