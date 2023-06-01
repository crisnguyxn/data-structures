package com.devjava.QuickSort;

import java.util.Arrays;

public class QuickSort {

    static void reverseSort(int[] arr){
        int leftPointer = 0;
        int rightPointer = arr.length -1;
        int pivot =  arr[leftPointer];
        while (leftPointer < rightPointer){
            if(pivot < arr[rightPointer]) {
                rightPointer--;
                if(pivot > arr[rightPointer]){
                    arr[leftPointer] = arr[rightPointer];
                    leftPointer++;
                    while(pivot > arr[leftPointer]){
                        leftPointer++;
                    }
                    arr[rightPointer] = arr[leftPointer];
                    rightPointer--;
                }
            }else{
                arr[leftPointer] = arr[rightPointer];
                leftPointer++;
            }
        }
        arr[leftPointer] = arr[rightPointer] = pivot;

    }
    public static void main(String[] args){
        int[] arr = {7,2,4,9,6,5,10};
        reverseSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
