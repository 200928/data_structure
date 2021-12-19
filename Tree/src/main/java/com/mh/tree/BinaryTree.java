package com.mh.tree;


import com.mh.tree.printer.BinaryTreeInfo;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/8/7 - 14:12
 * @ Description: com.mh.tree
 * @ Version: 1.0
 */
public abstract class BinaryTree<E> implements BinaryTreeInfo {

    protected int size;   // 节点个数
    protected Node<E> root; // 根节点

    private static final String VISITOR_NOT_NULL = "visitor must not be null";

    /*========================父类 Tree 的通抽象函数实现========================*/

    // 增加元素
    protected abstract void add(E element);

    // 删除元素
    protected abstract void remove(E element);

    // 是否包含元素
    protected abstract boolean contains(E element);

    // 传入一个元素找到该节点
    protected abstract Node<E> node(E element);

    /*=====================================================================*/

    /*========================父类 Tree 的通用函数实现========================*/

    // 元素数量
    protected int size() {
        return size;
    }

    // 是否为空
    protected boolean isEmpty() {
        return size == 0;
    }

    // 清空所有元素
    protected void clear() {
        root = null;
        size = 0;
    }

    /**
     * 判断元素是否为空
     */
    protected void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }

    // 前序遍历
    private void preorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
            return;
        }
        visitor.visit(node.element);
        preorderTraversal(node.left, visitor);
        preorderTraversal(node.right, visitor);
    }

    // 中序遍历
    private void inorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left, visitor);
        visitor.visit(node.element);
        inorderTraversal(node.right, visitor);
    }

    // 后序遍历
    private void postorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left, visitor);
        postorderTraversal(node.right, visitor);
        visitor.visit(node.element);
    }

    // 层序遍历
    private void levelOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null) {
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
    
    public void preorderTraversal(Visitor<E> visitor) {
        // 如果传入的 visitor 为空 抛出异常
        if (visitor == null) {
            throw new IllegalArgumentException(VISITOR_NOT_NULL);
        }
        System.out.print("Preorder Traversal: ");
        preorderTraversal(root, visitor);
        System.out.println();
    }

    public void inorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException(VISITOR_NOT_NULL);
        }
        System.out.print("inorder Traversal: ");
        inorderTraversal(root, visitor);
        System.out.println();
    }

    public void postorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException(VISITOR_NOT_NULL);
        }
        System.out.print("Postorder Traversal: ");
        postorderTraversal(root, visitor);
        System.out.println();
    }

    public void levelOrderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException(VISITOR_NOT_NULL);
        }
        System.out.print("Level Order Traversal: ");
        levelOrderTraversal(root, visitor);
        System.out.println();
    }


    /**
     * 前驱节点
     */
    public E predecessor(E element) {
        // 找到前驱结点
        Node<E> cur = predecessor(node(element));
        // 前驱节点可能为空，此时如果.element会出错，因此要判空
        return cur == null ? null : cur.element;
    }

    protected Node<E> predecessor(Node<E> node) {
        if (node == null) {
            return null;
        }
        Node<E> cur = node.left;
        // 如果左子树不空
        if (node.left != null) {
            while (cur.right != null) {
                cur = cur.right;
            }
            return cur;
        }
        // 如果左子树为空，一直找父节点，直到在父节点的右子树上
        while (node.parent != null && node != node.parent.right) {
            node = node.parent;
        }
        return node.parent;
    }

    /**
     * 后继节点
     */
    public E successor(E element) {
        // 找到后继结点
        Node<E> cur = successor(node(element));
        // 后继节点可能为空，此时如果.element会出错，因此要判空
        return cur == null ? null : cur.element;
    }

    protected Node<E> successor(Node<E> node) {
        if (node == null) {
            return null;
        }
        Node<E> cur = node.right;
        // 如果右子树不为空
        if (node.right != null) {
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        // 如果右子树为空，一直找父节点，直到在父节点的左子树上
        while (node.parent != null && node != node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }


    /**
     * 树的高度
     */
    public int height() {
        return height(root);
    }

    private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int heightIteration() {
        return heightIteration(root);
    }

    private int heightIteration(Node<E> node) {
        int height = 0;
        Queue<Node<E>> queue = new ArrayDeque<>();
        queue.add(node);
        int level = queue.size();   // 记录每层节点数量
        while (!queue.isEmpty()) {
            Node<E> tmp = queue.poll();
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add((tmp.right));
            }
            if (0 == --level) {
                height++;
                level = queue.size();
            }
        }
        return height;
    }

    /**
     * 判断是否为完全二叉树
     */
//    public boolean isComplete() {
//        Queue<Node<E>> queue = new ArrayDeque<>();
//        queue.add(root);
//        boolean leaf = false;
//        while (!queue.isEmpty()) {
//            Node<E> tmp = queue.poll();
//            if (!tmp.isLeaf() && leaf) {
//                return false;
//            }
//            if (tmp.hasTowChildren()) {
//                queue.add(tmp.left);
//                queue.add(tmp.right);
//            } else if (tmp.left == null && tmp.right != null) {
//                return false;
//            } else {
//                leaf = true;
//                if (tmp.left != null) {
//                    queue.add(tmp.left);
//                }
//            }
//        }
//        return true;
//    }
    public boolean isComplete() {
        Queue<Node<E>> queue = new ArrayDeque<>();
        queue.add(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> tmp = queue.poll();
            if (leaf && !tmp.isLeaf()) {
                return false;
            }
            if (tmp.left != null) {         // left != null
                queue.add(tmp.left);
            } else if (tmp.right != null) { // left == null && right != null
                return false;
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            } else {    // left != null && left == null
                leaf = true;
            }
        }
        return true;
    }

    /*=====================================================================*/

    protected static class Node<E> {
        public E element;
        public Node<E> left;
        public Node<E> right;
        public Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        // 判断是否为叶子节点
        public boolean isLeaf() {
            return left == null && right == null;
        }

        // 判断是否度为 2
        public boolean hasTowChildren() {
            return left != null && right != null;
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
//        Node<E> myNode = (Node<E>) node;
//        String string = "null";
//        if (myNode.parent != null) {
//            string = myNode.parent.element.toString();
//        }
//        return ((Node<E>) node).element + "_p(" + string + ")";
        return ((Node<E>) node).element;
    }

}