package cn.sharit.算法题._009_删除链表的倒数第N个结点;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        new Solution().delete2(head, 0).show();
    }

    public ListNode delete(ListNode head, int n) {
        ListNode cur = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int index = 0;
        while (cur != null) {
            map.put(index, cur);
            cur = cur.next;
            index++;
        }
        // 0,1,2,3,4,5 size=6 n=1
        int pos = map.size() - n;
        if (map.size() == 1) {
            return null;
        }
        if (pos == 0) {
            assert head != null;
            return head.next;
        }

        if (n == 1) {
            map.get(pos - 1).next = null;
        }

        map.get(pos - 1).next = map.get(pos + 1);
        return head;
    }

    public ListNode delete2(ListNode head, int n) {
        int size = head.size();
        int pos = size - n;
        ListNode cur = head;
        for (int i = 0; i < pos - 1; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return head;
    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void show() {
        ListNode cur = this;
        while (cur != null) {
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
        System.out.println();
    }

    public int size() {
        int size = 0;
        ListNode cur = this;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

}
