package com.logicmojo.stack;

import java.util.ArrayDeque;

public class InfixToPostFix {

    public static String infixToPostFix(String exp) {
        ArrayDeque<Character> st = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (char e : exp.toCharArray()) {
            if ((e >= 'A' && e <= 'Z') ||
                    (e >= 'a' && e <= 'z') ||
                    (e >= '0' && e <= '9')) {
                sb.append(e);
            } else if (e == '(') {
                st.push(e);
            } else if (e == ')') {
                while (!st.isEmpty() && st.peek()!='(') {
                    sb.append(st.peek());
                    st.pop();
                }
                st.pop();
            } else {
                while (!st.isEmpty() &&
                        ((e != '^' && precedence(st.peek()) >= precedence(e)) ||
                        (e == '^' && precedence(st.peek()) > precedence(e)))) {
                    sb.append(st.pop());
                }
                st.push(e);
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
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
