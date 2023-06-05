package com.devjava.leetcode;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReversionEquation {
    
    public static void main(String[] args){
        String S = "20-3+5*2";
        System.out.println(reverserE(S));
    }

    private static StringBuffer reverserE(String s) {
        Queue<Character> queue = new LinkedList<>();
        for(int i = s.length()-1;i>= 0 ; i--){
            queue.add(s.charAt(i));
        }
        System.out.println(queue);
        StringBuffer newS = new StringBuffer();
        while (!queue.isEmpty()){
            newS.append(queue.remove());
        }
        return newS;
    }
}
