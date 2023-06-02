package com.devjava.binarysearchtree;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> implements TreeADT<T> {
    private int nodeCount = 0;
    private Node<T> root = null;
    @Override
    public int size() {
        return nodeCount;
    }

    @Override
    public int height() {
        return height(root);
    }


    @Override
    public boolean contains(T element) {
        return contains(root,element);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean add(T element) {
        if(contains(element)) return false;
        root = add(root,element);
        nodeCount++;
        return true;
    }

    @Override
    public boolean remove(T element) {
        if(!contains(element)) return false;
        root = remove(root,element);
        nodeCount--;
        return true;
    }

    @Override
    public Iterator<T> traverse(TreeTraverseType type) {
        switch (type){
            case PRE_ORDER:return preOrderTraverse();
            case IN_ORDER:return inOrderTraverse();
            case POST_ORDER:return postOrderTraverse();
            case LEVEL_ORDER:return levelOrderTraverse();
            default: return null;
        }
    }

    private Iterator<T> levelOrderTraverse(){
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
    private Iterator<T> postOrderTraverse(){
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }
    private Iterator<T> inOrderTraverse(){
        final int expectedNode = nodeCount;
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        return new Iterator<T>() {
            final Node<T> node =root;
            Node<T> trav = root;
            @Override
            public boolean hasNext() {
                if(expectedNode != nodeCount) throw new ConcurrentModificationException();
                return node!= null && !stack.isEmpty();
            }

            @Override
            public T next() {
               while(trav!= null && trav.getLeft() != null){
                   stack.push(trav.getLeft());
                   trav = trav.getLeft();
               }

               Node<T> node = stack.pop();
               if(node.getRight()!=null){
                   trav = node.getRight();
                   stack.push(trav);
               }

               return node.getData();
            }
        };
    }
    private Iterator<T> preOrderTraverse(){

        final int expectedNode = nodeCount;
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);
        return new Iterator<>() {
            final Node<T> node =root;
            @Override
            public boolean hasNext() {
                if(expectedNode != nodeCount) throw new ConcurrentModificationException();
                return node!= null && !stack.isEmpty();
            }

            @Override
            public T next() {
                if(expectedNode != nodeCount) throw new ConcurrentModificationException();
                Node<T> node = stack.pop();
                if(node.getRight() != null) stack.push(node.getRight());
                if(node.getLeft() != null) stack.push(node.getLeft());
                return node.getData();
            }
        };
    }



    //PRIVATE

    private int height(Node<T> node){
        if(node == null) return 0;
        return 1 + Math.max(height(node.getRight()),height(node.getLeft()));
    }

    private boolean contains(Node<T> node,T element){
        if(node == null) return false;
        int result = element.compareTo(node.getData());
        if(result > 0){
            return contains(node.getRight(),element);
        } else if (result < 0) {
            return contains(node.getLeft(),element);
        }else{
            return true;
        }
    }

    private Node<T> add(Node<T> node, T element){
        if(node == null) {
            node = new Node<>(element, null, null);
        }else{
            int result =  element.compareTo(node.getData());
            if(result > 0){
                node.setRight(add(node.getRight(),element));
            }else{
                node.setLeft(add(node.getLeft(),element));
            }
        }

       return node;
    }

    private Node<T> remove(Node<T> node,T element){
        int result = element.compareTo(node.getData());
        if(result > 0){
            node.setRight(remove(node.getRight(),element));
        }else if(result < 0){
            node.setLeft(remove(node.getLeft(),element));
        }else{
            if(node.getRight() == null){
                Node<T> leftNode = node.getLeft();
                node.setData(null);
                node = null;
                return leftNode;
            }else if(node.getLeft() == null){
                Node<T> rightNode = node.getRight();
                node.setData(null);
                node = null;
                return rightNode;
            }else{
                T temp = getMin(node.getRight());
                node.setData(temp);
                node.setRight(remove(node.getRight(),temp));
            }
        }
        return node;
    }

    private T getMin(Node<T> right) {
        while(right.getLeft() != null){
            right = right.getLeft();
        }
        return right.getData();
    }

 // FOR FIND THE MAX NOE IN LEFT
//    private Node<T> getMax(Node<T> left) {
//        while(left.getRight() != null){
//            left = left.getLeft();
//        }
//        return left;
//    }

}
