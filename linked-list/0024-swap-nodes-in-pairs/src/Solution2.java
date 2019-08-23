/**
 * @author liwei
 * @date 2019/8/14 12:44 PM
 */
public class Solution2 {

    // 递归处理

    public ListNode swapPairs(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return head;
        }

        // 没有必要设置虚拟头结点了
        ListNode p1 = head;
        ListNode p2 = head.next;

        p1.next = swapPairs(p2.next);
        p2.next = p1;
        return p2;
    }
}
