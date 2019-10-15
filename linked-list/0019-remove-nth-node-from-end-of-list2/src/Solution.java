/**
 * @author liweiwei1419
 * @date 2019/10/11 11:25 上午
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLenOfNode(head);

        // 删除索引为 len - n 的结点
        // 有了虚拟头结点以后，就走 len - n 步，来到要删除的结点之前
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        for (int i = 0; i < len - n; i++) {
            curNode = curNode.next;
        }

        ListNode deleteNode = curNode.next;
        curNode.next = deleteNode.next;
        deleteNode.next = null;
        return dummyNode.next;
    }

    private int getLenOfNode(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
