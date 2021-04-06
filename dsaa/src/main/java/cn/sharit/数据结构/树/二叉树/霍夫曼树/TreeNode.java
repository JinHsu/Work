package cn.sharit.数据结构.树.二叉树.霍夫曼树;

/**
 * 树节点
 */
public class TreeNode implements Comparable<TreeNode> {

    Integer value;
    TreeNode left;
    TreeNode right;

    public TreeNode(Integer value) {
        this.value = value;
    }

    public TreeNode(Integer value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return value + "";
    }

    @Override
    public int compareTo(TreeNode o) {
        return this.value.compareTo(o.value);
    }
}
