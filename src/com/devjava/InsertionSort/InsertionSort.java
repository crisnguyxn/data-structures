package com.devjava.InsertionSort;

import java.util.Arrays;

public class InsertionSort {

    static void sort(int[] arr){
        for (int index = 1; index < arr.length; index++) {
            int current = arr[index];
            for (int position = index-1; position >= 0 ; position--) {
                if(current < arr[position]){
                      arr[position+1] = arr[position];
                      if(index == 1){
                          arr[position] = current;
                      }
                }else{
                    arr[position+1]  = current;
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {3,2,10,5,8,4,7};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
