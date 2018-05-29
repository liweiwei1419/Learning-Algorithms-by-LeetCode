
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
public class Solution {

    public ListNode createListNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    public void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println(" NULL ");
    }


    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        p2.next = swapPairs(p2.next);
        p1.next = p2.next;
        p2.next = p1;
        return p2;
    }


    public static void main(String[] args) {
        // write your code here
        // 给定 1->2->3->4, 你应该返回 2->1->4->3.
        int[] nums = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        ListNode listNode = solution.createListNode(nums);
        ListNode result = solution.swapPairs(listNode);
        solution.printListNode(result);
    }
}
