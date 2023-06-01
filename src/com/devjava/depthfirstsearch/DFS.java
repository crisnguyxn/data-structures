package com.devjava.depthfirstsearch;

import java.util.Arrays;
import java.util.Hashtable;

public class DFS {

    static Hashtable<Integer,int[]> hashtable = new Hashtable<>();
    static boolean[] visited = {false,false,false,false,false,false,false,false};
    static void getDFS(int nodeIndex){
        if(visited[nodeIndex]) return;
        visited[nodeIndex] = true;
        int[] neighbors = hashtable.get(nodeIndex);
        for(int neighbor:neighbors){
            getDFS(neighbor);
        }
    }


    public static void main(String[] args){
        int[][] graph = {{1,2},{0,3},{0,3},{4,5,6,2},{7,3},{7,3},{7,3},{4,5,6}};
        toHashTable(graph);
        getDFS(0);
        System.out.println(Arrays.toString(visited));
    }

    static void toHashTable(int[][] graph) {
        for (int i = 0; i < graph.length ; i++) {
            hashtable.put(i,graph[i]);
        }
    }

}
