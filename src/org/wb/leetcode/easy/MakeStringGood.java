package org.wb.leetcode.easy;

import java.util.Stack;

public class MakeStringGood {

    public static void main(String[] args) {
        System.out.println(makeGood("abBAcC"));
    }
    public static String makeGood(String s) {
        Stack<Character> charStack = new Stack<>();

        for(int i=0; i < s.length(); i++){
            char p = s.charAt(i);

            if(!charStack.isEmpty()){
                char top = charStack.peek();
                if(Math.abs(top - p) == 32){
                    charStack.pop();
                    continue;
                }
            }
            charStack.push(p);
        }

        StringBuilder sb = new StringBuilder();
        while(!charStack.isEmpty()){
            sb.append(charStack.pop());
        }

        return sb.reverse().toString();
    }
}
