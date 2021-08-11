package com.mh.tree.binarysearchtree;

import com.mh.tree.BinaryTree;
import com.mh.tree.Visitor;
import com.mh.tree.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/8/7 - 14:11
 * @ Description: com.mh.tree.binarysearchtree
 * @ Version: 1.0
 */
public class BinarySearchTree<E> extends BinaryTree<E> implements BinaryTreeInfo {

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
        remove(node(element));
    }

    @Override
    protected boolean contains(E element) {
        return node(element) != null;
    }

    private void remove(Node<E> node) {
        if (node == null) {
            return;
        }
        size--;
        // 度为 2 的节点
        if (node.hasTowChildren()) {
            // 我这里用后继节点取代它
            Node<E> s = successor(node);
            node.element = s.element;
            // node 变为了后继节点，删除度为 2(node)节点 现在只需要删除后继节点了(node)
            node = s;
        }
        // 删除 node 节点，此节点度必然是 1 or 0
        // 下面语句执行之后 replacement 可能为空(node 度为 0)，可能不空(node 度为 1)
        Node<E> replacement = node.left != null ? node.left : node.right;
        // 判定 replacement 是否为空
        if (replacement != null) {   // node 度为 1，node 父节点执行 replacement
            // 更改 parent
            replacement.parent = node.parent;
            // 更改 node.parent 的指向，先判定方向
            if (node.parent == null) {  // 删除的节点是根节点且度为 1
                root = replacement;
//                replacement.parent = null;  // 这一句上面已经写了，可以不写
            } else if (node == node.parent.left) { // 如果在左边
                node.parent.left = replacement;
            } else {    // 反之在右边
                node.parent.right = replacement;
            }
        } else if (node.parent == null) {    // node 度为 0，并且是根节点
            root = null;
        } else {    // node 度为 0，并且不是根节点
            if (node == node.parent.left) {     // node 是左子树
                node.parent.left = null;
            } else {    // node 是右子树
                node.parent.right = null;
            }
        }
    }


    @Override
    protected Node<E> node(E element) {
        Node<E> cur = root;
        while (cur != null) {
            int cmp = compare(element, cur.element);
            if (cmp == 0) {
                return cur;
            }
            if (cmp > 0) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return null;
    }


    public void preorderTraversal(Visitor<E> visitor) {
        // 如果传入的 visitor 为空 抛出异常
        if (visitor == null) {
            throw new IllegalArgumentException("visitor must not be null");
        }
        System.out.print("Preorder Traversal: ");
        preorderTraversal(root, visitor);
        System.out.println();
    }

    public void inorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor must not be null");
        }
        System.out.print("inorder Traversal: ");
        inorderTraversal(root, visitor);
        System.out.println();
    }

    public void postorderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor must not be null");
        }
        System.out.print("Postorder Traversal: ");
        postorderTraversal(root, visitor);
        System.out.println();
    }

    public void levelOrderTraversal(Visitor<E> visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("visitor must not be null");
        }
        System.out.print("Level Order Traversal: ");
        levelOrderTraversal(root, visitor);
        System.out.println();
    }


    /**
     * 比较器
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
//        Node<E> myNode = (Node<E>) node;
//        String string = "null";
//        if (myNode.parent != null) {
//            string = myNode.parent.element.toString();
//        }
//        return ((Node<E>) node).element + "_p(" + string + ")";
        return ((Node<E>) node).element;
    }
}
