package org.wb.leetcode.LeetCodeAndBlind75;

public class ReverseWordsInString {
    public static void main(String[] args) {
        System.out.println(reverseWords("this is the    new shit"));
    }

    public static String reverseWords(String s) {
        // clean string
        String cleanedString = s.trim().replaceAll(" +", " ");
        char[] strChars = cleanedString.toCharArray();

        // reverse all letters
        reverseString(0, strChars.length - 1, strChars);

        int i = 0, j = 0;
        while(j < strChars.length){
            if(strChars[j] == ' '){
                reverseString(i, j - 1, strChars);
                i = j + 1;
            }
            j++;
        }

        reverseString(i, j - 1, strChars);

        return String.valueOf(strChars);
    }

    public static void reverseString(int start, int end, char[] strArr) {
        while(start < end){
            char temp = strArr[start];
            strArr[start++] = strArr[end];
            strArr[end--] = temp;
        }
    }
}
