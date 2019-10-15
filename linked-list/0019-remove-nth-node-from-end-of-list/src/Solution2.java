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

    // 假设删除的是倒数第 3 个节点 4
    // -1 1 2 3 4 5 6
    // p  e
    //          e
    //    p       e
    //      p       e
    //        p       e

    public ListNode removeNthFromEnd2(ListNode head, int n) {
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

    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        // 要走 n 步
        while (curNode != null && n != -1) {
            curNode = curNode.next;
            n--;
        }
        ListNode pre = dummyNode;
        while (curNode != null) {
            pre = pre.next;
            curNode = curNode.next;
        }
        // 走到这里 curNode == null ，即 来到了链表的尾结点
        // 并且 pre 来到了要删除结点的下一个结点
        ListNode deleteNode = pre.next;
        pre.next = deleteNode.next;
        deleteNode.next = null;
        return dummyNode.next;
    }
}
