
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
 * pre cur next
 */
public class Solution {

    private ListNode reverseListNode(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rL1 = reverseListNode(l1);
        ListNode rL2 = reverseListNode(l2);

        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        int sum = 0;
        while (rL1 != null || rL2 != null) {
            if (rL1 != null) {
                sum += rL1.val;
                rL1 = rL1.next;
            }
            if (rL2 != null) {
                sum += rL2.val;
                rL2 = rL2.next;
            }
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            sum /= 10;
        }
        if (sum == 1) {
            curr.next = new ListNode(1);
        }
        return reverseListNode(dummyNode.next);
    }
}
