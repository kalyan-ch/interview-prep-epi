package org.wb.epi.Chap12HashTables;
import java.util.*;

public class HashTableBootcamp {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("debitcard", "badcredit", "algorithm", "logarithm", "money", "nomey");
        List<List<String>> anagramGroups = findAnagramGroups(strings);
        anagramGroups.forEach(anagramGroup ->{
            anagramGroup.forEach(System.out::print);
            System.out.println();
        });
    }

    private static List<List<String>> findAnagramGroups(List<String> strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();
        strings.forEach(s ->{
            char[] sortedArray = s.toCharArray();
            Arrays.sort(sortedArray);
            String sortedString = new String(sortedArray);
            List<String> anagramList = anagramMap.containsKey(sortedString) ? anagramMap.get(sortedString) : new ArrayList<>();
            anagramList.add(s);
            anagramMap.put(sortedString, anagramList);
        });

        anagramMap.keySet().forEach(key -> {
            if(anagramMap.get(key).size() > 1)
                result.add(anagramMap.get(key));
        });

        return result;
    }
}
