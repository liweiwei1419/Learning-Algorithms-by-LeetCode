
public class Solution6 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        ListNode next = current.next;
        while (next != null) {
            if (next.val == current.val) {
                current.next = next.next;
            } else {
                current = current.next;
            }
            next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        ListNode head1 = new  ListNode(nums);
        Solution6 solution6 = new Solution6();
        ListNode head2 = solution6.deleteDuplicates(head1);
        System.out.println(head2);
    }
}
