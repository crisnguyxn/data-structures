package com.devjava.depthfirstsearch;

import java.util.Arrays;
import java.util.Hashtable;

public class ConnectedComponents {
    static boolean[] visited = {false,false,false,false,false};
    static int  count = 0;
    static int[][] graph = {{1,2},{0,2},{0,1},{4},{3}};
    static int[] connections = new int[graph.length];
    static void getDFS(int nodeIndex){
        visited[nodeIndex] = true;
        connections[nodeIndex] = count;
        int[] neighbors = graph[nodeIndex];
        for(int neighbor:neighbors){
           if(!visited[neighbor]){
               getDFS(neighbor);
           }
        }
    }

    static void getConnection(){
        for (int i = 0; i < connections.length ; i++) {
            if(!visited[i]){
                count++;
                getDFS(i);
            }
        }
    }


    public static void main(String[] args){
        getConnection();
        System.out.println(Arrays.toString(visited));
        System.out.println(count);
        System.out.println(Arrays.toString(connections));
    }
}
