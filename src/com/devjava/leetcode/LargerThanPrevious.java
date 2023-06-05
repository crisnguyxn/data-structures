package com.devjava.leetcode;

import java.util.Arrays;

public class LargerThanPrevious {

    public static void main(String[] args){
        int[] arr = {1,3,2,10,4,8,9,0};
        sortArr(arr);
        System.out.println("Check");
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArr(int[] arr) {
        for (int i = 0; i < arr.length - 1 ; i++) {
            if(arr[i] > arr[i+1]){
                arr[i+1] = arr[i]+1;
                while(checkExisted(arr[i+1],i+1,arr)){
                    arr[i+1] +=1;
                }
            }
        }
    }

    private static boolean checkExisted(int value, int i1, int[] arr) {
        for (int j = i1+1; j < arr.length ; j++) {
            int element = arr[j];
            if(element == value){
                return true;
            }
        }
        return false;
    }
}
