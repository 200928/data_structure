package com.mh.tree.binarysearchtree;

import com.mh.tree.Visitor;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/8/9 - 13:04
 * @ Description: com.mh.tree.binarysearchtree
 * @ Version: 1.0
 */
public class OutTraversal<E> implements Visitor<E> {
    @Override
    public void visit(E element) {
        System.out.print(element + " ");
    }
}
