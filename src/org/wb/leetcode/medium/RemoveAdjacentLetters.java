package org.wb.leetcode.medium;

import static org.wb.leetcode.medium.MaxVowelsInSubstring.readFile;

public class RemoveAdjacentLetters {
    public static void main(String[] args) {
        try {
            String s = readFile("src/org/wb/leetcode/testfiles/longstring2.txt");
            long millis = System.currentTimeMillis();
            System.out.println(removeAdjacent(s, 2));
            long diff = System.currentTimeMillis() - millis;
            System.out.println(diff);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String removeAdjacent(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int length = -1;

        while(length != sb.length()){
            length = sb.length();
            for (int i = 0, count = 1; i < sb.length(); ++i) {
                if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                    count = 1;
                } else if (++count == k) {
                    sb.delete(i - k + 1, i + 1);
                    break;
                }
            }
        }


        return sb.toString();
    }


}
