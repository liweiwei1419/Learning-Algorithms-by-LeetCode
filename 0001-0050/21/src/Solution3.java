/**
 * 同 Solution2 ，是更简洁的一种写法
 *
 * @author liwei
 */
public class Solution4 {

    /**
     * 使用递归
     *
     * @param l1 有序链表
     * @param l2 有序链表
     * @return 有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
