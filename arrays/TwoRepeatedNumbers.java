package com.logicmojo.arrays;

public class TwoRepeatedNumbers {

    public static int[] indexApproach(int[] arr) {
        // code here
        int[] ans = new int[2];
        int ansInd = 0;
        for(int i=0;i<arr.length;i++) {
            int index = Math.abs(arr[i]);
            if (arr[index] > 0) {
                arr[index] = -arr[index];
            }
            else {
                ans[ansInd] = index;
                ansInd++;
            }
            if (ansInd == 2) {
                return ans;
            }
        }
        return ans;
    }

    public static int[] xorApproach(int[] arr) {

        /* step 1 xor the arrElement */
        int xor = 0;
        for (int j : arr) {
            xor^=j;
        }

        /* step 2 xor the ele from 1 to n */
        int max = 0;
        for (int n : arr) {
            max = Math.max(max,n);
        }
        for(int num=1;num<=max;num++) {
            xor^=num;
        }

        /* step 3 find the rightMostSetBit */
        int rightMostSetBit = xor & ~(xor-1);


        /* step 4 find the & odd and even groups for arrEle with rightMostSetBit
        * Group 1 (oddXor) → numbers where that bit is set (1)
        * Group 2 (evenXor) → numbers where that bit is unset (0)
        * */

        int num1=0, num2=0;
        for (int i=0;i<arr.length;i++) {
            if ((arr[i] & rightMostSetBit) == 0) {
                num1^=arr[i];
            } else {
                num2^=arr[i];
            }
        }

        /* step 4 find the & odd and even groups with 1 to n rightMostSetBit
         * Group 1 (oddXor) → numbers where that bit is set (1)
         * Group 2 (evenXor) → numbers where that bit is unset (0)
         * */

        for (int i=1;i <= max;i++) {
            if ((rightMostSetBit & i) == 0) {
                num1^=i;
            } else {
                num2^=i;
            }
        }
        return new int[]{num1, num2};
    }


}
