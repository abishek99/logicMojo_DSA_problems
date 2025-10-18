package com.logicmojo.stack;

import com.sun.jdi.event.StepEvent;

import java.util.ArrayDeque;

public class PostFixEvaulation {
    public static int postFixEvaulation(String[] arr) {
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (String s : arr) {
           if (s.matches("-?\\d+")) {
               st.push(Integer.parseInt(s));
           } else {
               if (st.size() >= 2) {
                   int a = st.pop();
                   int b = st.pop();
                   st.push(processOperation(a, b, s));
               } else {
                   return 0;
               }
           }
        }
        return st.pop();
    }

    public static int processOperation(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return Math.floorDiv(a, b);
            case "^":
                return (int) Math.pow(a, b);
            default:
                return 0;
        }
    }
}
