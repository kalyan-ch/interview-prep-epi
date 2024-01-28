package org.wb.leetcode.interview150.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public static void main(String[] args) {

        /*
        0 J     O    N      V
        1 F   G K   B S   K N
        2 G  U  H  M  M  J  V
        3 I Y   F N   F O
        4 O     G     H
         */

        String s = "ENGLISHWORDS";
        String converted = convertToZigZag(s, 3);

        System.out.println(converted.equals("EIONLSWRSGHD"));
    }

    private static String convertToZigZag(String s, int numRows) {

        if(numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();

        int i = 0;
        int increment = 2 * (numRows - 1);
        while(i < numRows) {
            for(int j = i; j < s.length(); j = j + increment) {
                result.append(s.charAt(j));
                int nextJump = j + increment - 2 * i;
                if (i > 0 && i < numRows - 1 && nextJump < s.length()) {
                    result.append(s.charAt(nextJump));
                }
            }

            i++;
        }

        return result.toString();
    }
}
