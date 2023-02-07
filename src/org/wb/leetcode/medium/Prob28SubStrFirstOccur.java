package org.wb.leetcode.medium;

public class Prob28SubStrFirstOccur {

    private static int firstOccurence(String hayStack, String needle) {
        int left = 0, right = 0, result = -1;
        while(left < hayStack.length() && right < hayStack.length()){
            right = left + 1;
            if(hayStack.charAt(left) == needle.charAt(0)){
                int j = 1;
                while(j < needle.length() && right < hayStack.length()) {
                    if(hayStack.charAt(right) == needle.charAt(j)){
                        right++;
                        j++;
                    } else{
                        break;
                    }
                }
                if(j == needle.length()){
                    result = left;
                    break;
                } else {
                    left++;
                }
            } else {
                left++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(firstOccurence("aa", "aaaa"));
    }
}
