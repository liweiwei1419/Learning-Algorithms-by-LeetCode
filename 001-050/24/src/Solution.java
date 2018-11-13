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

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
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
