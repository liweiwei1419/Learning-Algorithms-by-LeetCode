class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

// 参考资料：已经写了比较经得起推敲的笔记
// 下面的这两篇资料已经讲解得很清楚了
// https://www.qiujiawei.com/leetcode-problem-142/
// https://www.cnblogs.com/hiddenfox/p/3408931.html

public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }
        if (fast.next == null || fast.next.next == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = slow;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}