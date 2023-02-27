package org.wb.epi.Chap10Heaps;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.*;

public class HeapsBootCamp {

    //find k longest strings in the sequence which is a stream

    public static void main(String[] args) {
        String text = "Oh man, I haven't heard about X since college! I've never needed it for my job! He asks that in interviews? But that means someone out there thinks it's important to know, and, I don't know it! If they detect my ignorance, not only will I be summarily fired for incompetence without so much as a thank you, I will also be unemployable by people who ask question X! If people listen to Stevey, that will be everyone! I will become homeless and destitute! For not knowing something I've never needed before! This is horrible! I would attack X itself, except that I do not want to pick up a book and figure enough out about it to discredit it.";
        List<String> words = Arrays.asList(text.split(" "));
        List<String> kLongestStrings = longestK(5, words.iterator());

        ArraysUtils.printStrList(kLongestStrings);

    }

    public static List<String> longestK(int k, Iterator<String> iter){

        PriorityQueue<String> minHeap = new PriorityQueue<>(k ,
                Comparator.comparingInt(String::length));

        while(iter.hasNext()){
            String s = minHeap.peek();
            String nextStr = iter.next();

            if( s == null || s.length() < nextStr.length()){
                minHeap.add(nextStr);
            }

            
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        return new ArrayList<>(minHeap);

    }



}
