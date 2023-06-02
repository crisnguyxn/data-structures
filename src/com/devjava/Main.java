package com.devjava;

import com.devjava.binarysearchtree.BinarySearchTree;
import com.devjava.binarysearchtree.TreeTraverseType;

import java.util.Iterator;

public class Main {

    public static void main(String[] args){
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(99);
        bst.add(29);
        bst.add(15);
        bst.add(53);
        bst.add(34);
        bst.add(61);
        bst.add(71);
        bst.add(75);

        Iterator<Integer> traverse = bst.traverse(TreeTraverseType.PRE_ORDER);
        while(traverse.hasNext()){
            System.out.println(traverse.next());
        }
    }
}
