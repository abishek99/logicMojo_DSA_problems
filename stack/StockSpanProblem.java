package com.logicmojo.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class StockSpanProblem {

    public ArrayList<Integer> BruteForcecalculateSpan(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            int j = i;
            while (j>=0 && arr[j] <= arr[i]) {
                count++;
                j--;
            }
            list.add(count);
            count = 0;
        }
        return list;
    }

    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayDeque<Integer> st = new ArrayDeque<>(arr.length);
        ArrayList<Integer> list = new ArrayList<>();
        st.push(0);
        list.add(1);
        for (int i = 1; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                list.add(i+1);
            }
            else {
                list.add(i - st.peek());
            }
            st.push(i);
        }
        return list;
    }
}
