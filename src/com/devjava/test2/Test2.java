package com.devjava.test2;

import java.util.Arrays;

public class Test2 {

    public static void main(String[] args){
        int[] dc = {-1,1,0,0};
        int[] dr = {0,0,-1,+1};
        String S = "><^v";
        Character[][] matrix = new Character[3][S.length()+2];
        boolean[][] visited = new boolean[3][S.length()+2];
        for (int i = 1; i <= matrix[1].length-2  ; i++) {
            matrix[1][i] = S.charAt(i-1);
            visited[1][i] = true;
        }
        int count =0;
        for (int i = 0; i < S.length() ; i++) {
            char x = S.charAt(i);
            int[] xPos = {1,i+1};
            System.out.println(Arrays.toString(xPos));
            switch (x){
                case '<':
                    xPos[1] += dc[0];
                    System.out.println(Arrays.toString(xPos));
                    System.out.println(visited[xPos[0]][xPos[1]] + "check");
                    if(!visited[xPos[0]][xPos[1]]){
                        visited[xPos[0]][xPos[1]+1] = false;
                        count++;
                    }else{
                        continue;
                    }
                    break;
                case '>':
                    xPos[1] += dc[1];
                    System.out.println(Arrays.toString(xPos));
                    System.out.println(visited[xPos[0]][xPos[1]] + "check");
                    if(!visited[xPos[0]][xPos[1]]){
                        visited[xPos[0]][xPos[1]-1] = false;
                        count++;
                    }else{
                        continue;
                    }
                    break;
                case '^':
                    xPos[0] += dr[2];
                    System.out.println(Arrays.toString(xPos));
                    System.out.println(visited[xPos[0]][xPos[1]] + "check");
                    if(!visited[xPos[0]][xPos[1]]){
                        visited[xPos[0]+1][xPos[1]] = false;
                        count++;
                    }else{
                        continue;
                    }
                    break;
                default:
                    xPos[0] += dr[3];
                    System.out.println(Arrays.toString(xPos));
                    System.out.println(visited[xPos[0]][xPos[1]] + "check");
                    if(!visited[xPos[0]][xPos[1]]){
                        visited[xPos[0]-1][xPos[1]] = false;
                        count++;
                    }else{
                        continue;
                    }
                    break;

            }
        }
        System.out.println(Arrays.deepToString(visited));
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(count);
    }
}

