/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * @author liwei
 */
public class Solution2 {

    // 假设删除的是倒数第 3 个节点 4
    // -1 1 2 3 4 5 6
    // p  e
    //          e
    //    p       e
    //      p       e
    //        p       e
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            end = end.next;
        }
        while (end != null) {
            pre = pre.next;
            end = end.next;
        }
        ListNode delete = pre.next;
        pre.next = delete.next;
        delete.next = null;
        return dummyNode.next;
    }
}
