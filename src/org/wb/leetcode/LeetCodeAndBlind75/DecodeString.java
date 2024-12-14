package org.wb.leetcode.LeetCodeAndBlind75;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String[] encodedStrs = {"3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef", "2[a10[v]]"};

        for(String s: encodedStrs){
            System.out.println(decodeString(s));
        }
    }

    public static String decodeString(String s){
        var result = new StringBuilder();
        var numStk = new Stack<Integer>();
        var strStk = new Stack<String>();
        var i = 0;

        while(i < s.length()){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
                int numTimes = 0;
                while(Character.isDigit(s.charAt(i))) {
                    numTimes = 10 * numTimes + (s.charAt(i) - '0');
                    i++;
                }
                numStk.push(numTimes);
            } else if(c == '[') {
                strStk.add(result.toString());
                result.setLength(0);
                i++;
            } else if(c == ']') {
                var strToRepeat = strStk.pop();
                int numTimes = numStk.pop();
                var tempSb = new StringBuilder(strToRepeat);

                tempSb.append(result.toString().repeat(numTimes));
                result = tempSb;
                i++;
            } else {
                result.append(c);
                i++;
            }
        }

        return result.toString();
    }
}
