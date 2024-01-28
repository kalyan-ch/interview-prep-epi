package org.wb.leetcode.interview150.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(20));
        System.out.println(intToRoman(10));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(1996));
    }

    public static String intToRoman(int num) {
        TreeMap<Integer, String> numToRom = new TreeMap<>();
        numToRom.put(1, "I");
        numToRom.put(4, "IV");
        numToRom.put(5, "V");
        numToRom.put(9, "IX");
        numToRom.put(10, "X");
        numToRom.put(40, "XL");
        numToRom.put(50, "L");
        numToRom.put(90, "XC");
        numToRom.put(100, "C");
        numToRom.put(400, "CD");
        numToRom.put(500, "D");
        numToRom.put(900, "CM");
        numToRom.put(1000, "M");


        List<String> numerals = new ArrayList<>();
        int x = num, place = 1;

        while(x != 0) {
            int numb = (x % 10) * place ;
            numerals.add(getRoman(numb, numToRom));

            x /= 10;
            place *= 10;
        }

        StringBuilder result = new StringBuilder();
        for(int i = numerals.size() - 1; i >= 0; i--) {
            result.append(numerals.get(i));
        }

        return result.toString();
    }

    private static String getRoman(int numb, TreeMap<Integer, String> numToRom) {
        if(numToRom.containsKey(numb)) {
            return numToRom.get(numb);
        }

        Integer closest = numToRom.floorKey(numb);

        if(closest == null){
            return "";
        }

        int times = 0;
        String appender = numToRom.get(closest);
        StringBuilder romanNumeral = new StringBuilder();
        double logClosest = Math.log10(closest);

        if(logClosest % 1 == 0) {
            times = numb / closest;
        } else {
            times = numb - closest;
            int closest2 = closest / 5;
            times = times / closest2;
            romanNumeral.append(numToRom.get(closest));
            appender = numToRom.get(closest2);
        }

        for(int i = 0; i < times; i++){
            romanNumeral.append(appender);
        }

        return romanNumeral.toString();
    }
}
