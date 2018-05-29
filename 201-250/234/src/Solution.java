import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// https://leetcode-cn.com/problems/palindrome-linked-list/description/
public class Solution {

    private ListNode createListNode(int[] num) {
        ListNode head = new ListNode(num[0]);
        ListNode cur = head;
        for (int i = 1; i < num.length; i++) {
            cur.next = new ListNode(num[i]);
            cur = cur.next;
        }
        return head;
    }


    private void printListNode(ListNode head) {

        while (head != null) {
            System.out.print(head.val);
            System.out.print(" -> ");
            head = head.next;
        }
        System.out.println(" NULL ");

    }


    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // n1 的下一个就是新链表，反转它
        ListNode cur = n1.next;
        n1.next = null;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 此时 pre 成为新链表开头
        while (head != null && pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // write your code here
        int[] nums = {1, 2, 0, 2, 1};
        Solution solution = new Solution();
        ListNode head = solution.createListNode(nums);
        boolean palindrome = solution.isPalindrome(head);
        System.out.println(palindrome);
    }
}
