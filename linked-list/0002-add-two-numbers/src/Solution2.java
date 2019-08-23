public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            sum /= 10;
        }
        if (sum == 1) {
            curr.next = new ListNode(1);
        }
        return dummyNode.next;
    }
}
