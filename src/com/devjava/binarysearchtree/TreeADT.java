package com.devjava.binarysearchtree;

import java.util.Iterator;

public interface TreeADT<T extends Comparable<T>> {
    int size();
    int height();
    boolean contains(T element);
    boolean isEmpty();
    boolean add(T element);
    boolean remove(T element);
    Iterator<T> traverse(TreeTraverseType type);


}
