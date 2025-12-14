package com.logicmojo.stack;

import java.util.ArrayDeque;

public class DecodeString {

    public static Result deocdeStingRec(int ind, String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (ind < s.length()) {
            if (Character.isDigit(s.charAt(ind))) {
               num = Integer.parseInt("" + s.charAt(ind));
            } else if (Character.isLetter(s.charAt(ind))) {
                sb.append(s.charAt(ind));
            } else if (s.charAt(ind) == '[') {
                Result newString = deocdeStingRec(ind + 1, s);
                StringBuilder repeat = new StringBuilder();
                while (num > 0) {
                    repeat.append(newString.res);
                    num--;
                }
                sb.append(repeat);
                ind = newString.ind;
            } else if (s.charAt(ind) == ']') {
                return new Result(sb.toString(), ind);
            }
            ind++;
        }
        return new Result(sb.toString(), ind);
    }
    private static class Result {
        String res;
        int ind;
        Result(String res, int ind) {
            this.res = res;
            this.ind = ind;
        }
    }
}
