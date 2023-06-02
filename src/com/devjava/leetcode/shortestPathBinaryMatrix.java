package com.devjava.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class shortestPathBinaryMatrix {
    public static void main(String[] args){
        int[][] grid = {{0,0,0,0,1},{1,0,0,0,0},{0,1,0,1,0},{0,0,0,1,1},{0,0,0,1,0}};
        boolean[][] visited = new boolean[grid.length][grid.length];
        int nodesInNextLayer = 0;
        int nodesInLastLayer = 1;
        System.out.println(findShortedPath(grid,visited,nodesInNextLayer,nodesInLastLayer));
    }

    private static int findShortedPath(int[][] grid,boolean[][] visited,int nodesInNextLayer,int nodesInLastLayer ) {
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        int count = 0;
        if(grid[0][0] != 0){
            return  -1;
        }
        xQueue.add(0);
        yQueue.add(0);
        visited[0][0] = true;
        while (xQueue.size() > 0){
            int x = xQueue.remove();
            int y = yQueue.remove();
            if(x == grid.length -1 && y == grid.length -1 ){
                return count+1;
            }
            findNeighbors(x,y,visited,grid,nodesInNextLayer,xQueue,yQueue);
            nodesInLastLayer--;
            if(nodesInLastLayer == 0){
                nodesInLastLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                count++;
            }
        }
        return -1;
    }

    private static void findNeighbors(int x, int y,boolean[][] visited,int[][] grid,int nodesInNextLayer,Queue<Integer> xQueue,Queue<Integer> yQueue) {
        int[] dc = {-1,+1,0,0,-1,+1,-1,+1};
        int[] dr = {0,0,-1,+1,-1,-1,+1,+1};
        for (int i = 0; i < 8 ; i++) {
            int nc = x + dc[i];
            int nr = y + dr[i];
            if(nc < 0 || nc >= grid.length) continue;
            if(nr < 0 || nr >= grid.length) continue;
            if(visited[nr][nc]) continue;
            if(grid[nr][nc] == 1) continue;
            xQueue.add(nc);
            yQueue.add(nr);
            visited[nr][nc] = true;
            nodesInNextLayer++;
        }
    }

}
