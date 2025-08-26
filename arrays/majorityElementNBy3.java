package com.logicmojo.arrays;

import java.util.ArrayList;
import java.util.List;

public class majorityElementNBy3 {
        public List<Integer> majorityElement(int[] nums) {
            int candidate1 = 0, candidate2 = 0;
            int votes1 = 0, votes2 = 0;
            for (int i=0; i<nums.length; i++) {
                if (candidate1 == nums[i]) {
                    votes1++;
                } else if (candidate2 == nums[i]) {
                    votes2++;
                } else if (votes1 == 0) {
                    candidate1 = nums[i];
                    votes1 = 1;
                } else if (votes2 == 0) {
                    candidate2 = nums[i];
                    votes2 = 1;
                } else {
                    votes1--;
                    votes2--;
                }
            }
            List<Integer> list = new ArrayList<>();
            if (candidate1 == candidate2) {
                list.add(candidate1);
                return list;
            }
            votes1 = 0;
            votes2 = 0;
            for (int i=0;i <nums.length;i++) {
                if (candidate1 == nums[i]) {
                    votes1++;
                }
                if (candidate2 == nums[i]) {
                    votes2++;
                }
            }
            if (votes1 > (nums.length/3)) {
                list.add(candidate1);
            }
            if (votes2 > (nums.length/3)) {
                list.add(candidate2);
            }
            return list;
        }
}
