package com.devjava.findshortedpath;

import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindPath {
    static int nodesInLeftLayer = 1;
    static int nodesInNextLayer;
    static int moveCount = 0;
    static boolean reachEnd = false;
    static String[][] matrix = {{"0","1","2","3","4"},{"0","1","X","3","X"},{"X","1","X","3","4"},{"X","1","2","X","4"},{"0","X","2","E","4"}};
    static int R = matrix.length;
    static int C = matrix.length;
    static boolean[][] visited = new boolean[5][5];
    //obstacle
    static Queue<Integer> xQueue = new LinkedList<>();
    static Queue<Integer> yQueue = new LinkedList<>();
    static int sc = 0;
    static int sr = 0;
    static void startFindShortedPath(int sc, int sr){
        xQueue.add(sc);
        yQueue.add(sr);
        visited[sr][sc] = true;
        while(xQueue.size() > 0){
            int c = xQueue.remove();
            int r = yQueue.remove();
            if(matrix[r][c].equals("E")) {
                reachEnd = true;
                break;
            }
            countNeighbors(c,r);
            nodesInLeftLayer--;
            if(nodesInLeftLayer == 0){
                nodesInLeftLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                moveCount++;
            }
        }
        System.out.println(moveCount);
    }

    private static void countNeighbors(int c, int r) {
        int[] dc = {-1,+1,0,0};
        int[] dr = {0,0,+1,-1};

        for (int i = 0; i < 4 ; i++) {
            int nc = c + dc[i];
            int nr = r + dr[i];
            if(nc < 0 || nc >= C) continue;
            if(nr < 0 || nr >= R) continue;
            if(visited[nr][nc]) continue;
            if(matrix[nr][nc].equals("X")) continue;
            xQueue.add(nc);
            yQueue.add(nr);
            visited[nr][nc] = true;
            nodesInNextLayer++;
        }
    }


    public static void main(String[] args){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                visited[i][j] = false;
            }
        }
        startFindShortedPath(sc,sr);
    }
}
