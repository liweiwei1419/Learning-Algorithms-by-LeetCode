
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


// pre cur next
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

    public static void main(String[] args) {
        // write your code here

        int[] num1 = new int[]{1, 1, 2, 3, 4, 5};
        int[] num2 = new int[]{1, 2, 3, 4, 4};
        Solution s = new Solution();
        ListNode listNode1 = s.createListNode(num1);
        ListNode listNode2 = s.createListNode(num2);
        s.printListNode(listNode1);
        s.printListNode(listNode2);

        ListNode node = s.addTwoNumbers(listNode1, listNode2);
        s.printListNode(node);
    }
}
