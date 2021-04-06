package cn.sharit.数据结构.链表.单向链表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 循环单向链表
 *
 * @param <T>
 */
public class CyclicLinkedList<T> {

    public Node<T> header; // 头节点

    public CyclicLinkedList() {
    }

    // 尾部添加节点
    public void add(Node<T> node) {
        if (header == null) {
            header = node;
            header.next = node;
        } else {
            Node<T> current = header;
            while (current.next != header) {
                current = current.next;
            }
            current.next = node;
            node.next = header;
        }
    }

    // 删除节点
    public void remove(Node<T> node) {
        // check sth
        if (header == null) {
            return;
        }
        if (header.next == header && header == node) { // 只有一个节点
            header = null;
            return;
        }
        Node<T> current = header; // node上一节点
        do {
            if (current.next == node) {
                break;
            }
            current = current.next;
        } while (current != header);

        current.next = node.next;

        // 删除了header,需要重新指定header
        if (node == header) {
            header = node.next;
        }
    }

    public void josephu(final int m) {
        Node<T> current = header;
        int c = 0;
        List<T> list = new ArrayList<>();
        while (header != null) {
            c++;
            if (c == m) {
                list.add(current.value);
                remove(current);// 出环
                c = 0; // 重新计数
            }
            current = current.next;
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    @Override
    public String toString() {
        if (header == null) {
            return "[]";
        }
        List<T> list = new ArrayList<>();
        Node<T> current = header;
        do {
            list.add(current.value);
            current = current.next;
        } while (current != header);

        return Arrays.toString(list.toArray());
    }
}
