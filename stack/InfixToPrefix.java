package com.logicmojo.stack;

import java.util.ArrayDeque;

public class InfixToPrefix {

    public static String infixToPrefix(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        s = new StringBuilder(s).reverse().toString();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                st.push(c);
            } else if (c == '(') {
                while (!st.isEmpty() && st.peek() != ')') {
                    sb.append(st.pop());
                }
                st.pop();
            } else if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            } else {
                while (!st.isEmpty() &&
                        ((c != '^' && precedence(c) <= precedence(st.peek()))
                                || (c == '^' && precedence(c) < precedence(st.peek())))) {
                    sb.append(st.pop());
                }
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
    private static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }
}
