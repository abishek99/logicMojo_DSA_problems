package com.logicmojo.stack;

import java.util.ArrayDeque;

public class PreFixToInfix {

    public static String prefixToInfix(String exp) {
        ArrayDeque<String> st = new ArrayDeque<>();
        for (int i = exp.length()-1; i>=0; i--) {
            if (Character.isLetterOrDigit(exp.charAt(i))) {
                st.push(String.valueOf(exp.charAt(i)));
            } else {
                String b ;
                if (!st.isEmpty()) {
                    b = st.pop();
                } else {
                    return "";
                }
                String a ;
                if (!st.isEmpty()) {
                    a = st.pop();
                } else {
                    return "";
                }
                st.push("("+b+exp.charAt(i)+a+")");
            }
        }
        return st.pop();
    }
}
