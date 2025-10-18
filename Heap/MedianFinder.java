package com.logicmojo.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;

    public MedianFinder() {
       left = new PriorityQueue<>(Collections.reverseOrder());
       right = new PriorityQueue<>();
    }

    public void add(int num) {
        if (left.isEmpty() || left.peek() > num) {
            left.offer(num);
        } else {
            right.offer(num);
        }
        if (left.size() - right.size() > 1) {
            right.offer(left.poll());
        } else if (right.size() - left.size() > 1) {
            left.offer(right.poll());
        }
    }

    public double getMedian() {
        if (left.isEmpty() || right.isEmpty()) {
            return -1;
        }
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            if (left.size() > right.size()) {
                return left.peek() * 1.0;
            } else {
                return right.peek() * 1.0;
            }
        }
    }


}
