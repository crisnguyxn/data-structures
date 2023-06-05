package com.devjava.leetcode;

import java.util.TreeSet;

public class distributeCandies {

    public static void main(String[] args){
        int[] candyType = {1,1,2,2,3,3};
        System.out.println(maxCandies(candyType));
    }

    private static int maxCandies(int[] candyType) {
        int maxCandies = candyType.length / 2;
        TreeSet<Integer> candies = new TreeSet<>();
        for (int j : candyType) {
            candies.add(j);
        }
        return Math.min(candies.size(), maxCandies);
    }
}
