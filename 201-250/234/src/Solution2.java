import java.util.Stack;

/**
 * @author liwei
 */
public class Solution2 {
    // 分清楚奇数和偶数结点两种情况，不反转链表，借助栈完成回文链表的判断
    //      slow
    // 1，2，3，4，5

    //   slow
    // 1，2，3，4

    /**
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        stack.add(slow.val);

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            stack.add(slow.val);
        }
        if (fast.next == null) {
            // 链表有奇数个结点
            stack.pop();
        }
        slow = slow.next;
        while (slow != null) {
            if (stack.pop() != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {1, 2, 3, 2, 1};
        ListNode head = new ListNode(nums);
        boolean palindrome = solution2.isPalindrome(head);
        System.out.println(palindrome);
    }
}
