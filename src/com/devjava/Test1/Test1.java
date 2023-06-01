package com.devjava.Test1;

import java.util.Arrays;
import java.util.OptionalInt;

public class Test1 {
    public static void main(String[] args){
        int[] A ={10,-100,1};
        int sum = 0;
        for (int i = 0; i < A.length ; i++) {
            sum+=A[i];
        }

        System.out.println(sum);
    }
}
