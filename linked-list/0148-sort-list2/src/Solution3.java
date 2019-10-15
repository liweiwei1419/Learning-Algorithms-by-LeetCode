public class Solution3 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode midNext = slow.next;
        slow.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(midNext);
        return mergeOfTwoSortListNode(l1, l2);
    }

    private ListNode mergeOfTwoSortListNode(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode curNode = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = l1;
                l1 = l1.next;
            } else {
                curNode.next = l2;
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        if (l1 != null) {
            curNode.next = l1;
        }
        if (l2 != null) {
            curNode.next = l2;
        }
        return dummyNode.next;
    }
}
