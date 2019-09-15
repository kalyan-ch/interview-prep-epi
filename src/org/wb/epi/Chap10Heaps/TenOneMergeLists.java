package org.wb.epi.Chap10Heaps;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.*;

public class TenOneMergeLists{

    private static class HeapEntry{
        int val;
        int arrayId;

        HeapEntry(int val, int arrayId){
            this.val = val;
            this.arrayId = arrayId;
        }

    }
    
    // merge k sorted lists into one
    public static void main(String[] args) {
        List<List<Integer>> sortedLists = new ArrayList<>();

        List<Integer> list1 = Arrays.asList(0, 3, 5);
        List<Integer> list2 = Arrays.asList(1, 2, 6, 12, 18);
        List<Integer> list3 = Arrays.asList( 4, 11, 13);
        
        sortedLists.add(list1);
        sortedLists.add(list2);
        sortedLists.add(list3);

        List<Integer> result = mergeKLists(sortedLists);
        ArraysUtils.printIntList(result);
    }

    private static List<Integer> mergeKLists(List<List<Integer>> sortedLists){
        List<Integer> result = new ArrayList<>();
        List<Iterator<Integer>> iters = new ArrayList<>();
        for(List<Integer> arr: sortedLists){
            iters.add(arr.iterator());
        }

        PriorityQueue<HeapEntry> minHeap = new PriorityQueue<>(sortedLists.size(), new Comparator<HeapEntry>(){
            public int compare(HeapEntry a1, HeapEntry a2){
                return Integer.compare(a1.val, a2.val);
            }
        });

        for(int i= 0; i < iters.size(); i++){
            minHeap.add(new HeapEntry(iters.get(i).next(), i));
        }

        while(!minHeap.isEmpty()){
            HeapEntry he = minHeap.poll();
            result.add(he.val);
            int arrayId = he.arrayId;

            if(iters.get(arrayId).hasNext()){
                minHeap.add(new HeapEntry(iters.get(arrayId).next(), arrayId));
            }

        }


        return result;
    }


}
