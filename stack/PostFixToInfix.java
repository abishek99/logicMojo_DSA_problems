package com.logicmojo.stack;

import java.util.ArrayDeque;

public class PostFixToInfix {

    public static String postFixtoInfix(String s) {
        ArrayDeque<String> st = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                st.push(String.valueOf(c));
            } else {
                String b;
                if (!st.isEmpty()) {
                    b = st.pop();
                } else {
                    return "";
                }
                String a;
                if (!st.isEmpty()) {
                    a = st.pop();
                } else {
                    return "";
                }
                st.push("("+a+c+b+")");
            }
        }
        return st.pop();
    }
}
