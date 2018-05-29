

// 用作练习
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // head = removeElements(head,val);
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
