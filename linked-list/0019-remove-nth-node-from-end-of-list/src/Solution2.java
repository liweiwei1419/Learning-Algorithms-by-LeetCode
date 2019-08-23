/**
 * @author liwei
 * @date 2019/8/14 4:18 AM
 */
public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slowNode = dummyNode;
        ListNode fastNode = head;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }
        while (fastNode != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        ListNode delete = slowNode.next;
        slowNode.next = delete.next;
        delete.next = null;
        return dummyNode.next;
    }
}
