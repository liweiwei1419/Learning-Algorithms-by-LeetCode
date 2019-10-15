/**
 * @author liweiwei1419
 * @date 2019/10/15 10:15 上午
 */
public class Solution3 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            curNode.next = new ListNode(val % 10);
            carry = val / 10;
            curNode = curNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            curNode.next = l2;
        } else {
            curNode.next = l1;
        }

        if (carry == 1) {
            curNode.next = new ListNode(1);
        }
        return dummyNode.next;
    }
}
