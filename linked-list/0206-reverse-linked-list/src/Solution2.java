/**
 * @author liwei
 * @date 2019/8/14 5:35 AM
 */
public class Solution2 {

    public ListNode reverseList(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}
