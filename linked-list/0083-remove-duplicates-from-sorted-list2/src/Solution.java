/**
 * @author liweiwei1419
 * @date 2019/10/15 11:29 上午
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                ListNode deleteNode = cur.next;
                cur.next = deleteNode.next;
                deleteNode.next = null;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
