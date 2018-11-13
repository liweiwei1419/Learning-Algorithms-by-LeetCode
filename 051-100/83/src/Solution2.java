

public class Solution2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode curr = pre.next;
        ListNode next;
        int p = pre.val;
        while (curr != null) {
            next = curr.next;
            if (curr.val == p) {
                pre.next = next;
                curr.next = null;
                curr = next;
            } else {
                p = curr.val;
                pre = curr;
                curr = next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 5};
        Solution2 solution2 = new Solution2();
        ListNode listNode = new ListNode(nums);
        ListNode deleteDuplicates = solution2.deleteDuplicates(listNode);
        System.out.println(deleteDuplicates);
    }
}
