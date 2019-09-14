package org.wb.epi.Chap8StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class EightTwoRPN {
    //rpn - reverse polish notation of the form AB[] - [] can be / * + -
    public static void main(String[] args) {
        System.out.println(evaluateRpn("3,4,*,2,+"));
    }

    private static int evaluateRpn(String rpnExp) {
        Deque<Integer> intermediateResults = new ArrayDeque<>();
        String[] symbols = rpnExp.split(",");

        for(String token: symbols){
            // it is a operator symbol
            if(token.length() == 1 && "-+/*".contains(token)){
                final int y = intermediateResults.pop();
                final int x = intermediateResults.pop();

                switch(token){
                    case "+":
                        intermediateResults.push((x+y));
                        break;
                    case "-":
                        intermediateResults.push((x-y));
                        break;
                    case "*":
                        intermediateResults.push((x*y));
                        break;
                    case "/":
                        intermediateResults.push((x/y));
                        break;
                    default:
                        throw new IllegalArgumentException();
                }

            }else{ // it is a number
                intermediateResults.push(Integer.parseInt(token));
            }

        }

        return intermediateResults.pop();
    }
}
