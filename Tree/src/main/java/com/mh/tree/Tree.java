package com.mh.tree;


import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/8/7 - 14:12
 * @ Description: com.mh.tree
 * @ Version: 1.0
 */
public abstract class Tree<E> {

    protected int size;   // 节点个数
    protected Node<E> root;   // 根节点
    protected Comparator<E> comparator;   // 比较器

    // 元素数量
    protected int size() {
        return size;
    }

    // 是否为空
    protected boolean isEmpty() {
        return size == 0;
    }

    // 增加元素
    protected abstract void add(E element);

    // 清空所有元素
    protected void clear() {
        root = null;
        size = 0;
    }

    // 删除元素
    protected abstract void remove(E element);

    // 是否包含元素
    protected abstract boolean contains(E element);

    // 前序遍历
    protected void preorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) {
            return;
        }
        visitor.visit(node.element);
        preorderTraversal(node.left, visitor);
        preorderTraversal(node.right, visitor);
    }

    // 中序遍历
    protected void inorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) {
            return;
        }
        inorderTraversal(node.left, visitor);
        visitor.visit(node.element);
        inorderTraversal(node.right, visitor);
    }

    // 后序遍历
    protected void postorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) {
            return;
        }
        postorderTraversal(node.left, visitor);
        postorderTraversal(node.right, visitor);
        visitor.visit(node.element);
    }

    // 层序遍历
    protected void levelOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) {
            return;
        }
        Queue<Node<E>> queue = new ArrayDeque<>();
        queue.add(root);
        Node<E> tmp = null;
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            visitor.visit(tmp.element);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
    }

    protected static class Node<E> {
        public E element;
        public Node<E> left;
        public Node<E> right;
        public Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}