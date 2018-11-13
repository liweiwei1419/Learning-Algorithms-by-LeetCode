/**
 * @author liwei
 * @date 18/7/4 下午8:46
 */
public class Solution3 {

    public ListNode reverseList(ListNode head) {
        // || head.next == null 这一步不能忘记
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
