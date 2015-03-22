package edu.nyu.yaowang.leetcode.stack;

import java.util.Stack;

/**
 * Created by Yao on 1/26/15.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {

        Stack<Integer> number = new Stack<Integer>();
        Stack<Character> expression = new Stack<Character>();

        for(int i=0; i<tokens.length; i++) {
            if(isDigital(tokens[i])) {
                number.push(Integer.parseInt(tokens[i]));
            } else {
                int latter = number.pop();
                int former = number.pop();
                number.push(calculate(former, latter, tokens[i].charAt(0)));
            }
        }

        return number.pop();

    }

    private Integer calculate(int former, int latter, char c){
        switch (c) {
            case '+': return former+latter;
            case '-': return former-latter;
            case '*': return former*latter;
            case '/': return former/latter;
            default: throw new IllegalArgumentException("invalid input");
        }



    }

    private boolean isDigital(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String [ ] args)
    {
        String[] s = {"2", "-1", "+", "3", "*"};
        EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
        System.out.println(test.evalRPN(s));
    }
}
