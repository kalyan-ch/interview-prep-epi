package org.wb.leetcode.easy;

import java.util.ArrayDeque;

public class Prob20ValidParanthesis {

    //check if a string has balanced brackets
    public static void main(String[] args) {
        String s = "[";

        System.out.println(isValid(s));
    }

    private static boolean isValid(String s){
        if("".equals(s)){
            return true;
        }

        ArrayDeque<Character> stack = new ArrayDeque<>();
        try{
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                switch(c){
                    case '(':
                    case '[':
                    case '{':
                        stack.addFirst(c);
                        break;
                    case ')':
                        char b = stack.pop();
                        if(b != '(')
                            return false;
                        break;
                    case ']':
                        b = stack.pop();
                        if(b != '[')
                            return false;
                        break;
                    case '}':
                        b = stack.pop();
                        if(b != '{')
                            return false;
                        break;
                }
            }
        }catch (Exception e){
            return false;
        }

        return stack.isEmpty();
    }

}
