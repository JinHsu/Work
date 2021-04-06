package cn.sharit.算法题._006_两数相加;


public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode node = root;
        int temp = 0;
        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                temp += cur1.val;
                cur1 = cur1.next;
            } else {
                temp += 0;
            }
            if (cur2 != null) {
                temp += cur2.val;
                cur2 = cur2.next;
            } else {
                temp += 0;
            }
            root.next = new ListNode(temp % 10, null);
            temp = temp > 9 ? 1 : 0;
            root = root.next;
        }

        if (temp == 1) {
            root.next = new ListNode(temp, null);
        }
        return node.next;
    }


    public static void main(String[] args) {
        // 342 465

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(6)));

        ListNode listNode = new Solution().addTwoNumbers(l1, l2);
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
}