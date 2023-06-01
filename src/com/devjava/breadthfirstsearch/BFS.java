package com.devjava.breadthfirstsearch;

import java.util.*;

public class BFS {

    static int[][] graph = {{7,8},{5,9},{7,6,8},{8},{6,8},{7,1},{2,9,4},{5,2,0},{0,2,4,3},{1,6}};
    static boolean[] visited = {false,false,false,false,false,false,false,false,false,false};
    static List<Integer> getBFS(int start, int end){
        List<Integer> prev= new ArrayList<>();
        for (int i = 0; i < graph.length ; i++) {
            prev.add(null);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int node = queue.remove();
            int[] neighbors = graph[node];
            for(int neighbor : neighbors){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    prev.set(neighbor,node);
                }
            }
        }

        return reverserPath(start,end,prev);
    }

    private static List<Integer> reverserPath(int start, int end, List<Integer> prev) {
        List<Integer> shortedPath =  new ArrayList<>(10);
        List<Integer> reversedPath =  new ArrayList<>(10);
        int prevIndex = end;
        shortedPath.add(prevIndex);
        while (prev.get(prevIndex) != null){
            prevIndex = prev.get(prevIndex);
            shortedPath.add(prevIndex);
        }
        for (int i = shortedPath.size() - 1; i >=0 ; i--) {
            reversedPath.add(shortedPath.get(i));
        }
        if(reversedPath.get(0) != 0){
            return null;
        }else{
            return reversedPath;
        }
    }


    public static void main(String[] args){
        System.out.println(getBFS(0,6));
    }
}
