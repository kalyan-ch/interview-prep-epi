package org.wb.neetcodeOneFifty.ArraysHashing;

import org.wb.epi.Chap5Arrays.ArraysUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        var result = groupAnagrams(strs);
        ArraysUtils.printStr2dList(result);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        var result = new ArrayList<List<String>>();
        var anagramMap = new HashMap<String, List<String>>();

        for (String str : strs) {
            var anagram = sortString(str);
            var group = anagramMap.getOrDefault(anagram, new ArrayList<>());
            group.add(str);
            anagramMap.put(anagram, group);
        }

        for(String key: anagramMap.keySet()) {
            result.add(anagramMap.get(key));
        }

        return result;
    }

    public static String sortString(String test) {
        char[] ar = test.toCharArray();
        Arrays.sort(ar);
        return String.valueOf(ar);
    }
}
