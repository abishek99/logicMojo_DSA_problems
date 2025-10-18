package com.logicmojo.stack;

import java.util.ArrayDeque;

public class PrefixToPostFix {
    public static String preFixToPostFix(String e) {
        ArrayDeque<String> st = new ArrayDeque<>();
        for (int i = e.length() - 1; i >= 0; i--) {
            if (Character.isLetterOrDigit(e.charAt(i))) {
                st.push(String.valueOf(e.charAt(i)));
            } else {
                if (st.size()>=2) {
                    String b = st.pop();
                    String a = st.pop();
                    st.push(b+a+e.charAt(i));
                } else {
                    return "";
                }
            }
        }
        return st.pop();
    }
}
