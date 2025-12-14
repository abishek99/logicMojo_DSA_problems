package com.logicmojo.greedyalgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FractionalKnapsack {

    public double fractionKnapsack(int[] val, int[]wt, int capacity) {
        PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingDouble((Item it) ->
                it.valuePerUnit).reversed());
        for (int i=0; i<val.length; i++) {
            pq.offer(new Item(val[i], wt[i]));
        }
        double totalCapacity = 0;
        while (!pq.isEmpty() && capacity > 0) {
            Item it = pq.poll();
            int capability = Math.min(capacity, it.weight);
            totalCapacity+= capability * it.valuePerUnit;
            capacity = capacity - capability;
        }
        return totalCapacity;
    }

    public class Item {
         int val;
         int weight;
         double valuePerUnit;

        public Item(int val, int weight) {
            this.weight = weight;
            this.val = val;
            this.valuePerUnit = val * 1.0 / weight;
        }
    }
}
