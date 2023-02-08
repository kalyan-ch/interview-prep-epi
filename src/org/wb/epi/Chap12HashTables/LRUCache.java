package org.wb.epi.Chap12HashTables;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    private Map<Integer, Integer> bookPrices;
    public LRUCache(int capacity){
        this.bookPrices = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() > capacity;
            }
        };
    }

    public int get(int isbnNum){
        return bookPrices.getOrDefault(isbnNum, -1);
    }

    public void put(int isbn, int price){
        bookPrices.get(isbn);
        if(!bookPrices.containsKey(isbn)){
            bookPrices.put(isbn, price);
        }
    }
}