package com.devjava.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.TreeSet;

public class FindMissingNumber {

    public static void main(String[] args){
        int[] arr = {1};
        int n = arr.length+1;
        System.out.println(missingNumber(arr,n));
    }

    private static int missingNumber(int[] arr,int n) {
        int value = -1;
        for (int i = 1; i <= 5 ; i++) {
            while(checkExist(i,arr)){
                i = i+1;
            }
            value = i;
            break;
        }
        return value;
    }

    private static boolean checkExist(int i,int[] arr) {
        for (int k : arr) {
            if (k == i) {
                return true;
            }
        }
        return false;
    }
}
