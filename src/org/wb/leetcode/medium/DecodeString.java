package org.wb.leetcode.medium;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String encoded = "a2[sd]3[v]ss";
        System.out.println(decode(encoded));
    }

    private static String decode(String s) {
        Stack<Integer> freq = new Stack<>();
        Stack<String> strs = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int k = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                k = k * 10 + c - '0';
            } else if (c == ']'){
                strs.push(curr.toString());
                String last = strs.pop();

                String currDecode = last.repeat(freq.pop());
                curr = new StringBuilder(currDecode);
            } else if (c == '[') {
                freq.push(k);
                strs.push(curr.toString());

                curr = new StringBuilder();
                k = 0;
            } else {
                curr.append(c);
            }
        }

        return curr.toString();
    }
}
