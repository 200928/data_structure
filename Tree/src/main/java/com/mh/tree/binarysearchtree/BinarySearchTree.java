package com.mh.tree.binarysearchtree;

import com.mh.tree.Tree;
import com.mh.tree.Visitor;
import com.mh.tree.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/8/7 - 14:11
 * @ Description: com.mh.tree.binarysearchtree
 * @ Version: 1.0
 */
public class BinarySearchTree<E> extends Tree<E> implements BinaryTreeInfo {

    BinarySearchTree() {
        this(null);
    }

    BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        // 如果添加的是第一个节点（根节点）
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }
        // 添加的不是第一个节点
        Node<E> node = root;
        int cmp = 0;
        Node<E> parent = root;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) {  // element 比 node.element 大
                node = node.right;
            } else if (cmp < 0) {   // element 比 node.element 小
                node = node.left;
            } else {    // element 等于 node.element 作覆盖处理
                node.element = element;
                return;
            }
        }
        // 看插入哪边
        Node<E> newNode = new Node<>(element, parent);
        if (cmp > 0) {  // 加入右树
            parent.right = newNode;
        } else if (cmp < 0) {   // 加入左树
            parent.left = newNode;
        }
        size++;
    }

    @Override
    protected void remove(E element) {

    }

    @Override
    protected boolean contains(E element) {
        return false;
    }


    public void preorderTraversal(Visitor<E> visitor) {
        // 如果传入的 visitor 为空 抛出异常
        if (visitor == null) {
            throw new IllegalArgumentException("visitor must not be null");
        }
        System.out.print("\n" + "Preorder Traversal: ");
        preorderTraversal(root, visitor);
    }

    public void inorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor must not be null");
        }
        System.out.print("\n" + "inorder Traversal: ");
        inorderTraversal(root, visitor);
    }

    public void postorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor must not be null");
        }
        System.out.print("\n" + "Postorder Traversal: ");
        postorderTraversal(root, visitor);
    }

    public void levelOrderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor must not be null");
        }
        System.out.print("\n" + "Level Order Traversal: ");
        levelOrderTraversal(root, visitor);
    }

    /**
     * 比较器
     *
     * @param e1
     * @param e2
     * @return
     */
    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        return ((Comparable<E>) e1).compareTo(e2);
//        return (int) ((2 + 1) * Math.random()) - (int) (2 * Math.random());
    }

    /**
     * 判断元素是否为空
     *
     * @param element
     */
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        String string = "null";
        if (myNode.parent != null) {
            string = myNode.parent.element.toString();
        }
        return ((Node<E>) node).element + "_p(" + string + ")";
    }
}
