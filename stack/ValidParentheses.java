package com.logicmojo.stack;

import java.util.ArrayDeque;

public class ValidParentheses {

    public static boolean isValid(String s) {
        ArrayDeque<Character> st = new ArrayDeque<>(s.length());
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                st.push(c);
            } else {
                if (!st.isEmpty() && ((c == '}' && st.peek() == '{') ||
                        (c == ']' && st.peek() == '[') ||
                        (c == ')' && st.peek() == '('))) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
