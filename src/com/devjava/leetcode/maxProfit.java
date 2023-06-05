package com.devjava.leetcode;

public class maxProfit {
    public static void main(String[] args){
        int[] prices = {1,2};
        System.out.println(getMaxProfit(prices));
    }

    private static int getMaxProfit(int[] prices) {
        int value = 0;
        for (int i = 0; i < prices.length -1; i++) {
            for (int j = i+1; j < prices.length ; j++) {
                if(prices[j] < prices[i]) continue;
                value = checkMaxProfit(value,prices[j]-prices[i]);
            }
        }
        return value;
    }

    private static int checkMaxProfit(int value ,int i) {
       return Math.max(i, value);
    }
}
