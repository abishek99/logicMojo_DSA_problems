package com.logicmojo.arrays;

public class TrappingRainWater {

    public static int trapRainWater(int[] nums) {
        int waterTrapped = 0;
        int previousBlock = nums[0];
        int max = 0;
        int index = 0;
        for (int i=0; i<nums.length; i++) {
            if (max <= nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        //firsthalf
        for (int i=1;i <=index ;i++) {
            if (previousBlock < nums[i]) {
                previousBlock = nums[i];
            }
            if (nums[i] == 0) {
                waterTrapped+=previousBlock;
            } else if (nums[i] < previousBlock) {
                waterTrapped+=(previousBlock-nums[i]);
            }
        }
        //secondhalf
        previousBlock = 0;
        for (int i=nums.length-1; i >= index ; i--) {
            if (previousBlock < nums[i]) {
                previousBlock = nums[i];
            }
            if (nums[i] == 0) {
                waterTrapped+=previousBlock;
            } else if (nums[i] < previousBlock) {
                waterTrapped+=(previousBlock-nums[i]);
            }
        }
        return waterTrapped;
    }
}
