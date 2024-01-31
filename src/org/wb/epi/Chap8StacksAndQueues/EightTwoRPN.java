package org.wb.epi.Chap8StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class EightTwoRPN {
    //rpn - reverse polish notation of the form AB[] - [] can be / * + -
    public static void main(String[] args) {
        String[][] tokens = {{"2","1","+","3","*"}, {"4","13","5","/","+"}, {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}};
        for(String[] tok: tokens) {
            System.out.println(evaluateRpn(tok));
        }
    }

    private static int evaluateRpn(String[] tokens) {
        Deque<Integer> intermediateResults = new ArrayDeque<>();

        for(String token: tokens){
            // it is a operator symbol
            if(token.length() == 1 && "-+/*".contains(token)){
                final int y = intermediateResults.pop();
                final int x = intermediateResults.pop();

                switch (token) {
                    case "+" -> intermediateResults.push((x + y));
                    case "-" -> intermediateResults.push((x - y));
                    case "*" -> intermediateResults.push((x * y));
                    case "/" -> intermediateResults.push((x / y));
                    default -> throw new IllegalArgumentException();
                }

            }else{ // it is a number
                intermediateResults.push(Integer.parseInt(token));
            }

        }

        return intermediateResults.pop();
    }
}
