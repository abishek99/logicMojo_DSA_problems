package com.logicmojo.stack;

import java.util.ArrayDeque;

public class PostFixToPrefix {

    public static String postFixToPrefix(String s) {
        ArrayDeque<String> st = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                st.push(String.valueOf(c));
            } else {
                if (st.size() >= 2) {
                    String b = st.pop();
                    String a = st.pop();
                    st.push(c+a+b);
                } else {
                    return "";
                }
            }
        }
        return st.pop();
    }
}
