package cn.sharit.数据结构.链表.单向链表;

/**
 * 单向链表节点
 *
 * @param <T>
 */
public class Node<T> {

    T value; // 节点存储的值
    Node<T> next; // 指向下一个节点的引用

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
