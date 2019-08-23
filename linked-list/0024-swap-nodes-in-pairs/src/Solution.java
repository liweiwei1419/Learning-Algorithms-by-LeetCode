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

public class Solution {
    public ListNode swapPairs(ListNode head) {
        // 特判
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode curNode = dummyNode;
        ListNode p1;
        ListNode p2;
        ListNode nextNode;
        while (curNode.next != null && curNode.next.next != null) {
            p1 = curNode.next;
            p2 = p1.next;

            // 先保存一下
            nextNode = p2.next;
            // 穿针引线
            curNode.next = p2;
            p2.next = p1;
            p1.next = nextNode;
            // 特别注意，下一轮 curNode 应该站在 p1
            curNode = p1;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 给定 1->2->3->4, 你应该返回 2->1->4->3.
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        Solution solution = new Solution();
        ListNode swapPairs = solution.swapPairs(head);
        System.out.println(swapPairs);
    }
}