/**
 * @author liwei
 * @date 18/7/4 下午9:42
 */
public class Solution2 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode newHead = swapPairs(p2.next);
        // 下面这两行代码可以交换
        p1.next = newHead;
        p2.next = p1;
        return p2;
    }
}
