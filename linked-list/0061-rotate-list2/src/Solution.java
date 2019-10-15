class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        // 先计算这个链表有多少个节点，并且返回末尾节点的索引
        int n = 1;
        ListNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
            n++;
        }
        k = k % n;
        if (k != 0) {
            // 先接上去，否则会出现空指针异常
            curNode.next = head;
            ListNode pre = head;
            for (int i = 1; i < n - k; i++) {
                pre = pre.next;
            }
            ListNode newHead = pre.next;

            pre.next = null;
            return newHead;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        Solution s = new Solution();
        ListNode rotateRight = s.rotateRight(node1, 0);
        System.out.println(rotateRight);
    }
}
