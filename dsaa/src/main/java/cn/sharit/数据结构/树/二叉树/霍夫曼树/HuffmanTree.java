package cn.sharit.数据结构.树.二叉树.霍夫曼树;

import java.util.*;

/**
 *
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        HuffmanTree huffmanTree = new HuffmanTree();
        TreeNode node = huffmanTree.build(arr);
        System.out.println("node=" + node);
        buildHuffmanCodeTable(node, "");
    }

    static Map<Integer, String> huffmanCodeTable = new HashMap<>();

    public static void buildHuffmanCodeTable(TreeNode node, String s) {
        if (node != null) {
            buildHuffmanCodeTable(node.left, s + "0");
            buildHuffmanCodeTable(node.right, s + "1");
            if (node.left == null && node.right == null) {
                System.out.println(s);
                huffmanCodeTable.put(node.value, s);
            }
        }
    }

    /**
     * 将数组构建成Huffman树
     */
    public TreeNode build(int[] arr) {
        List<TreeNode> list = buildNodeList(arr);

        //
        while (list.size() > 1) {
            Collections.sort(list); // 对数组进行排序

            TreeNode leftNode = list.get(0);
            TreeNode rightNode = list.get(1);
            int value = leftNode.value + rightNode.value;
            TreeNode parentNode = new TreeNode(value);
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            list.add(parentNode);
            list.remove(leftNode);
            list.remove(rightNode);
        }

        return list.get(0);
    }

    public List<TreeNode> buildNodeList(int[] arr) {
        List<TreeNode> list = new ArrayList<>();

        for (int value : arr) {
            list.add(new TreeNode(value));
        }

        return list;
    }

}
