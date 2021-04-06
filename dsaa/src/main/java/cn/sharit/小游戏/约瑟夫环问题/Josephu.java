package cn.sharit.小游戏.约瑟夫环问题;

import cn.sharit.数据结构.链表.单向链表.CyclicLinkedList;
import cn.sharit.数据结构.链表.单向链表.Node;

/**
 * 约瑟夫环问题
 */
public class Josephu {

    public static void main(String[] args) {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        //
        CyclicLinkedList<Integer> circleList = new CyclicLinkedList<>();
        circleList.add(node1);
        circleList.add(node2);
        circleList.add(node3);
        circleList.add(node4);
        circleList.add(node5);
        System.out.println(circleList);
        System.out.println("===========");

        circleList.josephu(2);
    }
}
