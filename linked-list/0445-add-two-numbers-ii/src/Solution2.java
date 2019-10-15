import java.util.Stack;

// pre cur next

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null) {
            stack1.push(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            stack2.push(p2.val);
            p2 = p2.next;
        }
        Stack<Integer> result = new Stack<>();
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            result.push(sum % 10);
            sum /= 10;
        }
        if (sum == 1) {
            result.push(1);
        }
        ListNode head = new ListNode(result.pop());
        ListNode cur = head;
        while (!result.isEmpty()) {
            cur.next = new ListNode(result.pop());
            cur = cur.next;
        }
        return head;
    }
}
