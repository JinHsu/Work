package cn.sharit.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {

    public ListNode reverseList(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;

        while (k > 1) {
            start = start.next;
            k--;
        }

        while (start.next != null) {
            start = start.next;
            end = end.next;
        }

        return end;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        new Test3().reverseList(head, 3);
    }
}

/**
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int x, ListNode node) {
        val = x;
        next = node;

    }

    @Override
    public String toString() {
        List<Integer> nodes = new ArrayList<>();
        ListNode t = this;
        while (t != null) {
            nodes.add(t.val);
            t = t.next;
        }
        return Arrays.toString(nodes.toArray());
    }
}

