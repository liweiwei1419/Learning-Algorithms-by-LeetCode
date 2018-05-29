public class Solution4 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            if (q.val == p.val) {
                q = q.next;
            } else { // q.val != p.val
                // 这一段不好理解，要多花些时间
                p.next = q;
                p = q;
                q = q.next;
            }
        }
        p.next = null;
        return head;
    }
}
