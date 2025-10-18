package com.logicmojo.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreqEle {

    public int[] topFreqEle(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i=0 ;i < k; i++) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }


}
