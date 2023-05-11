package org.wb.leetcode.hard;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        /*System.out.println(calculate("22-3*5"));
        System.out.println(calculate("2 + 3 * 4 - 5"));*/
        System.out.println(calculateIII("2*(5+5*2)/3+(6/2+8)"));
        System.out.println(calculateIII("-1+4*3/3/3"));
        /*System.out.println(calculate("3+2*2"));
        System.out.println(calculate("3/2"));
        System.out.println(calculate("2*4/2"));
        System.out.println(calculate("2*4/8*16"));*/
    }

    private static int calculateII(String s){
        if(s.equals("") || s == null)
            return 0;

        int result = 0, curr = 0;
        Stack<Integer> st = new Stack<>();
        char op = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') {
                continue;
            }

            if(Character.isDigit(c)){
                curr *= 10;
                curr += c - '0';
            }

            if(!Character.isDigit(c) || i == s.length() - 1){
                if(op == '-'){
                    st.push(-curr);
                } else if (op == '+'){
                    st.push(curr);
                } else if (op == '*') {
                    st.push(st.pop() * curr);
                } else if (op == '/') {
                    st.push(st.pop() / curr);
                }

                op = c;
                curr = 0;
            }
        }

        while(!st.isEmpty()) {
            result += st.pop();
        }

        return result;
    }

    private static int calculateIII(String s){
        if(s == null || "".equals(s))
            return 0;

        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();

        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == ' '){
                continue;
            }

            if(Character.isDigit(c)){
                curr = c - '0';

                while(i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    curr *= 10;
                    curr += s.charAt(i + 1) - '0';
                    i++;
                }

                nums.push(curr);
            } else if(c == '(') {
                ops.push(c);
            } else if(c == ')') {
                while(ops.peek() != '('){
                    nums.push(calc(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else if(c == '+' || c == '-' || c == '*' || c == '/'){
                while (!ops.isEmpty() && precedence(c, ops.peek())) {
                    nums.push(calc(ops.pop(), nums.pop(), nums.pop()));
                }

                // Dealing with the negative number
                if (c == '-') {
                    if (nums.isEmpty()) { // case1: 1st non-empty character is the negative number
                        nums.push(0);
                    } else { // case2: 1st non-empty character in parentheses is the negative number
                        int index = i - 1;
                        while (index >= 0 && s.charAt(index) == ' ') {
                            index--;
                        }
                        if (s.charAt(index) == '(') {
                            nums.push(0);
                        }
                    }
                }

                ops.push(c);
            }
        }

        while(!ops.isEmpty()){
            nums.push(calc(ops.pop(), nums.pop(), nums.pop()));
        }

        return nums.pop();
    }

    private static boolean precedence(char op1, char op2) {
        if(op2 == '(' || op2 == ')'){
            return false;
        }

        if((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')){
            return false;
        }

        return true;
    }

    private static int calc(char op, int a, int b){
        return switch (op) {
            case '+' -> a + b;
            case '-' -> b - a;
            case '*' -> a * b;
            case '/' -> b / a;
            default -> 0;
        };
    }

}
