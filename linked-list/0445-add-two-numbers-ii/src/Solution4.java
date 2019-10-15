import java.util.Stack;

/**
 * @author liwei
 * @date 18/7/5 上午10:30
 */
public class Solution4 {

    // 我自己写的，更好理解

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode next = null;
        ListNode curNode;
        int sum = 0;
        while (!stack1.empty() || !stack2.empty()) {
            if (!stack1.empty()) {
                sum += stack1.pop();
            }
            if (!stack2.empty()) {
                sum += stack2.pop();
            }
            curNode = new ListNode(sum % 10);
            curNode.next = next;
            next = curNode;
            sum /= 10;
        }
        if (sum == 1) {
            ListNode head = new ListNode(sum);
            head.next = next;
            return head;
        }
        return next;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums1 = {7,2,4,3};
        int[] nums2 = {5,6,4};
        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);
        ListNode addTwoNumbers = solution4.addTwoNumbers(head1, head2);
        System.out.println(addTwoNumbers);
    }
}
