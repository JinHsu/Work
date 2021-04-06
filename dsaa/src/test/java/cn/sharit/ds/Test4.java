package cn.sharit.ds;

public class Test4 {

    // 1,2,3
    // 1,1,3,4
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        ListNode l2 = new ListNode(1, new ListNode(1, new ListNode(3, new ListNode(4, null))));
        System.out.println(mergeTwoLists(l1, l2));
    }
}

