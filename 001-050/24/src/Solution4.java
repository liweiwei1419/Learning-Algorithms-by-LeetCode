public class Solution4 {
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
