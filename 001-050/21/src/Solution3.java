/**
 * @author liwei
 */
public class Solution3 {

    /**
     * 使用递归
     *
     * @param l1 有序链表
     * @param l2 有序链表
     * @return 有序链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curNode = dummyNode;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curNode.next = p1;
                p1 = p1.next;
            } else {
                curNode.next = p2;
                p2 = p2.next;
            }
            curNode = curNode.next;
        }
        if (p1 == null) {
            curNode.next = p2;
        }
        if (p2 == null) {
            curNode.next = p1;
        }
        return dummyNode.next;
    }
}
