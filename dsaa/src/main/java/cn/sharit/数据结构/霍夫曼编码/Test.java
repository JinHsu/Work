package cn.sharit.数据结构.霍夫曼编码;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        // 霍夫曼编码压缩字符串
        String src = "i like like like java do you like a java";

        HuffmanCodeUtils utils = new HuffmanCodeUtils();

        byte[] bytes = utils.encode(src.getBytes());
        System.out.println(Arrays.toString(bytes));

    }
}
