/**
 * @author liwei
 * @date 2019/8/14 3:53 PM
 */
public class Solution2 {

    public ListNode sortList(ListNode head) {
        // 特判

        if (head == null || head.next == null) {
            return head;
        }

        // 找中点，应该找到左边中位数，先切断联系
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 先切断联系
        ListNode head2 = slow.next;
        slow.next = null;

        ListNode sortList1 = sortList(head);
        ListNode sortList2 = sortList(head2);

        return mergeOfTwoSortList(sortList1, sortList2);
    }

    private ListNode mergeOfTwoSortList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val < head2.val) {
            head1.next = mergeOfTwoSortList(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeOfTwoSortList(head1, head2.next);
            return head2;
        }
    }
}
