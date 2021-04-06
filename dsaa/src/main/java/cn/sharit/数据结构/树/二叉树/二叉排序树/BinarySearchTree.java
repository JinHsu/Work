package cn.sharit.数据结构.树.二叉树.二叉排序树;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉排序树
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 5, 7, 8};
        List<TreeNode> list = new ArrayList<>();
        for (int value : arr) {
            list.add(new TreeNode(value));
        }
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (TreeNode treeNode : list) {
            binarySearchTree.add(treeNode);
        }
        binarySearchTree.midOrder();
        System.out.println(binarySearchTree.root.height());
        System.out.println(binarySearchTree.root.leftHeight());
        System.out.println(binarySearchTree.root.rightHeight());
    }

    TreeNode root;

    // 中序遍历
    public void midOrder() {
        if (root != null) {
            root.midOrder();
        }
    }

    // 添加
    void add(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    // 删除
    void remove(TreeNode node) {

    }

}

/**
 * 二叉树节点
 */
class TreeNode {

    public Integer value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    // 二叉排序树添加
    public void add(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

    }

    // 前序遍历 (自己，左树，右树)
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历（左树，自己，右树）
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    // 后序遍历（左树，右树，自己）
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 计算当前节点的高度
    public int height() {
        return Math.max(leftHeight(), rightHeight()) + 1;
    }

    public int leftHeight() {
        return left == null ? 0 : left.height();
    }

    public int rightHeight() {
        return right == null ? 0 : right.height();
    }

    // 左旋转
    public void leftRotate() {

    }

    // 右旋转
    public void rightRotate() {

    }

    // 双旋转
    public void rotate() {

    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "value=" + value +
                '}';
    }
}
