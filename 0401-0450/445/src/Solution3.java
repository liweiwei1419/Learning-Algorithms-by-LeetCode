import java.util.Stack;

/**
 * 最简洁的解法
 * 1、使用栈模拟了我们手算加法的过程：先算个位，再十位；
 * 2、这里计算出的结果一层一层往前面加，是我们平时不常见的，要多练习。
 */
public class Solution3 {

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
        ListNode cur = new ListNode(0);
        ListNode head;
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            cur.val = sum % 10;
            // 下一个节点存的值是：是否进位
            head = new ListNode(sum / 10);
            head.next = cur;
            cur = head;
            sum /= 10;
        }
        return cur.val == 0 ? cur.next : cur;
    }
}
