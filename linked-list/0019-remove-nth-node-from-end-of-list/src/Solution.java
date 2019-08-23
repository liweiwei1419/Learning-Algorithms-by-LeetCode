
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = nums[0];
        ListNode curr = this;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val + " -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

// 快慢指针、虚拟结点
// 关键：使用待删除结点的上一个结点删除它
// 在草稿纸上画图，搞清边界条件
// 学会调试链表程序

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        // 走 n + 1 步
        ListNode fastNode = dummyNode;
        while (fastNode != null && n != -1) {
            fastNode = fastNode.next;
            n--;
        }

        ListNode slowNode = dummyNode;
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }

        ListNode deleteNode = slowNode.next;
        slowNode.next = deleteNode.next;
        deleteNode.next = null;
        return dummyNode.next;
    }
}