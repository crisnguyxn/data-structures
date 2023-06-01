package com.devjava.BubbleSort;

import java.util.Arrays;

public class BubbleSort {

    static void sort(int[] arr){
        int k =0;
        for (int i = 0; i <= arr.length - 2  ; i++) {
            ++k;
            for (int j = 0; j < arr.length - k ; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
         int[] arr = {5,4,8,2,1};
         sort(arr);
         System.out.println(Arrays.toString(arr));
    }
}
