package com.mh.tree;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/8/9 - 12:56
 * @ Description: com.mh.tree
 * @ Version: 1.0
 */
public interface Visitor<E> {
    void visit(E element);
}
