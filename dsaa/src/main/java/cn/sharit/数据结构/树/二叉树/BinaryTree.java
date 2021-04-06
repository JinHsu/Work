package cn.sharit.数据结构.树.二叉树;

/**
 * <ul>
 * <li>完全二叉树</li>
 * <li>满二叉树</li>
 * </ul>
 *
 * <ol>
 * <li>前序遍历</li>
 * <li>中序遍历</li>
 * <li>后序遍历</li>
 * </ol>
 */
public class BinaryTree<T> {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);

        root.left = node2;
        root.right = node3;

        node2.left = node4;

        node3.left = node5;
        node3.right = node6;

        node5.right = node7;

        BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
        System.out.println("前序遍历");
        binaryTree.preOrder();

        System.out.println("中序遍历");
        binaryTree.midOrder();

        System.out.println("后序遍历");
        binaryTree.postOrder();
    }

    BinaryTreeNode<T> root;

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    // 前序遍历
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        }
    }

    // 中序遍历
    public void midOrder() {
        if (root != null) {
            root.midOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if (root != null) {
            root.postOrder();
        }
    }

    // TODO 栈遍历
}
