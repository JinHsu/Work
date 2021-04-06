package cn.sharit.数据结构.霍夫曼编码;

import java.util.*;

public class HuffmanCodeUtils {
    /**
     * key: 权重路径长度（WPL）
     * value: 字符的字节编码
     */
    Map<Byte, String> huffmanCodeTable = new HashMap<>();

    /**
     * 压缩
     */
    public byte[] encode(byte[] bytes) {
        System.out.println("bytes=" + Arrays.toString(bytes));
        System.out.println("bytes.length=" + bytes.length);

        // 1.统计字符权重
        Map<Byte, Integer> charWeightTable = buildCharWeightTable(bytes);
        System.out.println("charWeightTable=" + charWeightTable);

        // 2.构建字符权重的哈夫曼树
        CharNode huffmanTreeRoot = buildHuffmanTree(charWeightTable);

        // 3.遍历所有的叶子节点，得到字符权重的哈夫曼编码表
        buildhuffmanCodeTable(huffmanTreeRoot, "");
        System.out.println("huffmanCodeTable=" + huffmanCodeTable);

        // 4.构建压缩后的字符字节数组
        return encodeHuffmanCode(bytes);
    }

    /**
     * 解压
     */
    public byte[] decode(byte[] bytes) {
        return null;
    }

    private Map<Byte, Integer> buildCharWeightTable(byte[] bytes) {
        Map<Byte, Integer> charWeightTable = new HashMap<>();
        for (byte b : bytes) {
            charWeightTable.merge(b, 1, Integer::sum);
        }
        return charWeightTable;
    }

    private CharNode buildHuffmanTree(Map<Byte, Integer> charWeightTable) {
        List<CharNode> list = new ArrayList<>();

        for (byte value : charWeightTable.keySet()) {
            Integer weight = charWeightTable.get(value);
            list.add(new CharNode(value, weight));
        }

        //
        while (list.size() > 1) {
            Collections.sort(list); // 对数组进行排序

            CharNode leftNode = list.get(0);
            CharNode rightNode = list.get(1);
            int weight = leftNode.weight + rightNode.weight;
            CharNode parentNode = new CharNode(null, weight);
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            list.add(parentNode);
            list.remove(leftNode);
            list.remove(rightNode);
        }
        return list.get(0);
    }

    private void buildhuffmanCodeTable(CharNode node, String s) {
        if (node != null) {
            buildhuffmanCodeTable(node.left, s + "0");
            buildhuffmanCodeTable(node.right, s + "1");
            if (node.value != null) { // 叶子节点
                huffmanCodeTable.put(node.value, s);
            }
        }
    }

    private byte[] encodeHuffmanCode(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffmanCodeTable.get(b));
        }
        String s = sb.toString();
        int length = (s.length() + 7) / 8;
        byte[] bs = new byte[length];

        for (int i = 0, index = 0; i < s.length(); i += 8, index++) {
            String substring;
            if (i + 8 < s.length()) {
                substring = s.substring(i, i + 8);
            } else {
                substring = s.substring(i);
            }
            bs[index] = (byte) Integer.parseInt(substring, 2);
        }

        return bs;
    }

}
