package BinarySearchTree;

import BinarySearchTree.printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author: 范名辉
 * @ Date: 2021/2/6 - 14:17
 * @ Description: BinarySearchTree
 * @ Version: 1.0
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {

    private int size;

    private Node<E> root;

    private Comparator<E> comparator;

    // 空比较器 则 E 要实现 Comparable 接口
    public BinarySearchTree() {
        this(null);
    }

    // 传入一个比较器
    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    /*
    二叉树高度 - 递归
     */
    public int heightRecursive() {
        return heightRecursive(root);
    }

    private int heightRecursive(Node<E> node) {
        if (node == null) return 0;
        int L = heightRecursive(node.left);  // 计算 node 左子树高度
        int R = heightRecursive(node.right); // 计算 node 右子树高度
        // 取最高的一边
        return 1 + L > R ? L : R;
//        return 1 + Math.max(height(node.left), height(node.right));
    }

    /*
    二叉树高度 - 迭代
     */
    public int heightIteration() {
        return heightIteration(root);
    }

    private int heightIteration(Node<E> root) {
        if (root == null) return 0;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();   // 记录每一层个数
        int height = 0;                 // 记录高度
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            if (--levelSize == 0) { // 即将访问下一层
                height++;
                levelSize = queue.size();  // 赋值为下一层高度
            }
        }
        return height;
    }

    /*
    判断是否为完全二叉树
    一共有四种情况 左右不为空 左右为空 左不空右空 左空右不空
    后面三种情况用一个boolean值存储，初始为false
     */
    public boolean isComplete() {
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (leaf && node.isLeaf()) { // 要求是叶子节点但是不是叶子结点
                return false;
            }
            if (node.hasTowChildren()) { // 度数为二的节点
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) {
                return false;
            } else { // 这里 左不空右空(要入队) 和 左右都为空
                leaf = true;
                if (node.left != null)
                    queue.offer(node.left);
            }
        }
        return true;
    }

    public boolean isCompleteOptimization() {
        if (root == null) return false;
        boolean leaf = false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();

            if (leaf && node.isLeaf()) { // 要求是叶子节点但是不是叶子结点返回 false
                return false;
            }

            if (node.left != null) {
                queue.offer(node.left);
            } else if (node.right != null) { // node.leaf == null && node.right != null
                return false;
            }
            if (node.right != null) {
                queue.offer(node.right);
            } else { // node.right == null
                leaf = true;
            }
        }
        return true;
    }

    public int Size() {
        return size;
    } // 元素数量

    public boolean isEmpty() {
        return size == 0;
    } // 是否为空

    public void clear() {

    } // 清空所有元素

    public void add(E element) {
        elementNotNullCheck(element);   // 检查元素是否为 null
        // 添加第一个节点
        if (root == null) {
            root = new Node<E>(element, null);
            size++;
            return;
        }
        // 添加的不是第一个节点
        Node<E> node = root;
        Node<E> parent = root;  // 记录添加位置节点
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) { // 新 element 比我当前节点值大，放右边
                node = node.right;
            } else if (cmp < 0) { // 新 element 比我当前节点值小，放左边
                node = node.left;
            } else { // 相等，覆盖原来的节点值
                node.element = element;
                return;
            }
        }
        // 看看插入到父节点哪一边
        if (cmp > 0) { // 比父节点值大，放右边
            parent.right = new Node<E>(element, parent);
        } else { // 比父节点值小，放左边
            parent.left = new Node<E>(element, parent);
        }
        size++;
    } // 添加元素

    public void remove(E element) {

    } // 删除元素

    public boolean contains(E element) {
        return false;
    } // 是否包含某元素

    /*
    前序遍历
     */
    public void preOrderTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
        preOrderTraversal(root, visitor);
    }

    private void preOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        preOrderTraversal(node.left, visitor);
        preOrderTraversal(node.right, visitor);
    }

    /*
    中序遍历
     */
    public void inorderTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
        inorderTraversal(root, visitor);
    }

    private void inorderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        inorderTraversal(node.left, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
        inorderTraversal(node.right, visitor);
    }

    /*
    后续遍历
     */
    public void postOrderTraversal(Visitor<E> visitor) {
        if (visitor == null) return;
        postOrderTraversal(root, visitor);
    }

    private void postOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor.stop) return;
        postOrderTraversal(node.left, visitor);
        postOrderTraversal(node.right, visitor);
        if (visitor.stop) return;
        visitor.stop = visitor.visit(node.element);
    }

    /*
    层序遍历
     */
    public void levelOrderTraversal(Visitor<E> visitor) {
        if (root == null || visitor == null) return;
        Queue<Node<E>> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            Node<E> node = nodeQueue.poll();
            // 如果是 visitor.visit 返回 true 则停止遍历，退出循环
            if (visitor.visit(node.element)) return;
            if (node.left != null) nodeQueue.offer(node.left);
            if (node.right != null) nodeQueue.offer(node.right);
        }
    }

    public static abstract class Visitor<E> {
        boolean stop;

        // true 则停止遍历
        public abstract boolean visit(E element);
    }

    private int compare(E e1, E e2) {
        if (comparator != null) {
            return comparator.compare(e1, e2);
        }
        // 如果没事实现 Comparable 接口会异常提示
        return ((Comparable<E>)e1).compareTo(e2);
    }

    // 检查 element 值是否为空
    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null"); // 元素不能为 null
        }
    }


    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;     // 父节点

        private Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        // 叶子节点
        boolean isLeaf() {
            return left == null && right == null;
        }

        // 度为二节点
        boolean hasTowChildren() {
            return left != null && right != null;
        }

        public String toString() {
            return element.toString();
//            return "Node{" + "element=" + element.toString() + '}';
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
        return ((Node<E>) node).element;
    }
}
