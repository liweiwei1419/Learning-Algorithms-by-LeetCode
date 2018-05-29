
public class Solution5 {

    /**
     * 从一个有序的链表中删除重复的元素
     * 思路：从后面往前面看，有重复就删除
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode next = current.next;

        while (next != null) {
            if (next.val == current.val) { // 1,1,1,1,2
                next = next.next;
            } else {
                current.next = next;
                current = next;
                next = next.next;
            }
        }
        current.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 3, 3, 3, 3};
        ListNode head1 = new ListNode(nums);
        Solution5 solution5 = new Solution5();
        ListNode deleteDuplicates = solution5.deleteDuplicates(head1);
        System.out.println(deleteDuplicates);
    }
}
