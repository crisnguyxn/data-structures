package com.devjava.leetcode;

public class LongestSub {

    public static void main(String[] args){
        String s1 = "aieef";
        String s2 = "klaied";
        getSubString(s1,s2);
    }

    private static void getSubString(String s1, String s2) {
        String subStr1 = String.valueOf(filterString(s1));
        String subStr2 = String.valueOf(filterString(s2));
        StringBuffer result = new StringBuffer();
        int length = Math.min(subStr2.length(), subStr1.length());
        for (int i = 0; i < length ; i++) {
            if(subStr1.charAt(i) == subStr2.charAt(i)){
                result.append(subStr1.charAt(i));
            }
        }
        System.out.println(result);
    }

    private static StringBuffer filterString(String s1) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < s1.length() ; i++) {
            char x = s1.charAt(i);
            switch (x){
                case 'u':
                    s.append('u');
                    break;
                case 'e':
                    s.append('e');
                    break;
                case 'o':
                    s.append('o');
                    break;
                case 'a':
                    s.append('a');
                    break;
                case 'i':
                    s.append('i');
                    break;
                default:
                    break;
            }
        }
        return s;
    }
}
