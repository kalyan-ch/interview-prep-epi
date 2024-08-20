package org.wb.Misc;


import java.util.*;

/**

 Map<OrderID,List of items>

 eg : 1000 - milk, egg
 1002 - milk, bread
 1003 - bread, apple
 1004 - apple,orange,egg,milk


 Result
 Which items are present in maximum number of orders
 milk



 **/

public class SampleClass {
    public static void main(String[] args) {
        Map<Integer, List<String>> orderMap = new HashMap<>();

        orderMap.put(1000, Arrays.asList("milk", "egg"));
        orderMap.put(1001, Arrays.asList("milk", "bread", "apple"));
        orderMap.put(1002, Arrays.asList("apple", "bread"));
        orderMap.put(1003, Arrays.asList("apple", "egg", "orange", "milk"));

        List<String> result = findMaxItems(orderMap);

        System.out.println();
        for(String s: result) {
            System.out.print(s+", ");
        }
        System.out.println();
    }

    static List<String> findMaxItems(Map<Integer, List<String>> orderMap) {

        Map<String, Integer> itemCountMap = new HashMap<>();

        orderMap.keySet().forEach(orderId -> {
            List<String> items = orderMap.get(orderId);

            for(String item: items) {
                int count = itemCountMap.getOrDefault(item, 0);
                itemCountMap.put(item, count+1);
            }
        });

        TreeMap<Integer, List<String>> countToItemsMap = new TreeMap<>();

        itemCountMap.keySet().forEach(item -> {
            int count = itemCountMap.get(item);
            List<String> items = countToItemsMap.getOrDefault(count, new ArrayList<>());

            items.add(item);
            countToItemsMap.put(count, items);
        });

        return countToItemsMap.lastEntry().getValue();
    }
}
