
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


// https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
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


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curr.next = new ListNode(p1.val);
                p1 = p1.next;
            } else {
                curr.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if (p1 == null) {
            curr.next = p2;
        } else {
            curr.next = p1;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        // write your code here

        // 输入：1->2->4, 1->3->4
        // 输出：1->1->2->3->4->4


        int[] num1 = {1, 2, 4};
        int[] num2 = {1, 3, 4};


        Solution solution = new Solution();

        ListNode l1 = solution.createListNode(num1);
        ListNode l2 = solution.createListNode(num2);


        ListNode result = solution.mergeTwoLists(l1, l2);
        solution.printListNode(result);


    }
}
