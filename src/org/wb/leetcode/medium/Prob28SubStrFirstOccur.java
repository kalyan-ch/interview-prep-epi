package org.wb.leetcode.medium;

public class Prob28SubStrFirstOccur {

    private static int firstOccurence(String hayStack, String needle) {
        int i = 0, j = 0, result = 0;

        while(i < hayStack.length()) {
            char h = hayStack.charAt(i);
            char n = needle.charAt(j);

            if(h == n){
                i++;
            } else {
                result = -1;
            }
            j++;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(firstOccurence("sadbutsad", "sad"));
    }
}
