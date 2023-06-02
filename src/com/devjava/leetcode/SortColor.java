package com.devjava.leetcode;

import java.util.*;

public class SortColor {

    public static void main(String[] args){
        int[] nums = {2,0,2,1,1,0};
        sortColor(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColor(int[] nums) {
//        big(O) notation = O(n^2)

        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < nums.length-1 ; j++) {
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
