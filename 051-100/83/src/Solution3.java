public class Solution3 {

    // 穿针引线的问题，画图就好
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode curNode = head.next;
        int preVal = pre.val;
        while (curNode != null) {
            if (curNode.val != preVal) {
                preVal = curNode.val;
                pre = curNode;
                curNode = curNode.next;
            } else {
                ListNode next = curNode.next;
                curNode.next = null;
                pre.next = next;
                curNode = next;
            }
        }
        return head;
    }
}
