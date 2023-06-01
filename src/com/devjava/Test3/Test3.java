package com.devjava.Test3;

public class Test3 {

    class Solution {
        public int solution(int[] A) {
            int n = A.length;

            int ans = 0;
            for (int i = 0; i < n-1; i++) {
                int sum = A[i] + A[i+1];
                ans = Math.max(ans, 1 + getCount(i+2, sum, A));
            }

            return ans;
        }

        private int getCount(int idx, int sum, int[] arr) {
            int n = arr.length;
            if (idx >= n-1) {
                return 0;
            }

            int count = 0;
            if (arr[idx] + arr[idx+1] == sum)
                count = 1 + getCount(idx+2, sum, arr);


            return Math.max(count, getCount(idx+1, sum, arr));
        }
    }

}
