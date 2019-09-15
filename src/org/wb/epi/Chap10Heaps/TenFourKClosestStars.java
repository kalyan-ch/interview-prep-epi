package org.wb.epi.Chap10Heaps;

import java.util.*;

public class TenFourKClosestStars{

    private static class Star implements Comparable<Star>{
        double x, y, z;

        Star(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

        double distFromEarth(){
            return Math.sqrt(x*x + y*y + z*z);
        }

        @Override
        public String toString(){
            return "Star - x: "+x+" y: "+y+" z: "+z+" distFromEarth: "+distFromEarth();
        }

        @Override
        public int compareTo(Star star1){
            return Double.compare(this.distFromEarth(), star1.distFromEarth());
        }

    }

    public static void main(String[] args) {
        List<Star> stars = new ArrayList<>();
        stars.add(new Star(1, 1, 1));
        stars.add(new Star(1, 2, 1));
        stars.add(new Star(2, 2, 2));
        stars.add(new Star(3, 3, 4));
        stars.add(new Star(1, 1, 3));
        stars.add(new Star(1, 2, 3));

        List<Star> result = findKClosestStars(stars.iterator(), 3);

        for(Star str: result){
            System.out.println(str);
        }


    }

    public static List<Star> findKClosestStars(Iterator<Star> stars, int k){
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        while(stars.hasNext()){
            Star str = stars.next();
            maxHeap.add(str);

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        return new ArrayList<>(maxHeap);

    }

}