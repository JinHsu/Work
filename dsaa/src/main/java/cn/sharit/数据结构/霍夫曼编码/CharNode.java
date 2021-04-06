package cn.sharit.数据结构.霍夫曼编码;

/**
 * 字符节点
 */
public class CharNode implements Comparable<CharNode> {

    public final Byte value; // 字符
    public final int weight; // 节点权重

    public CharNode left; // 左子节点
    public CharNode right; // 右子节点

    public CharNode(Byte value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    @Override
    public int compareTo(CharNode o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "CharNode{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }

}
