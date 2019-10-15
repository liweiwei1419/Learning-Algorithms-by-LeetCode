/**
 * @author liweiwei1419
 * @date 2019/10/16 1:57 上午
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
