import java.util.Stack;

// pre cur next
public class Solution2 {

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

    public static void main(String[] args) {
        // write your code here

        int[] num1 = new int[]{1, 1, 2, 3, 4, 5};
        int[] num2 = new int[]{1, 2, 3, 4, 4};
        Solution2 s = new Solution2();
        ListNode listNode1 = s.createListNode(num1);
        ListNode listNode2 = s.createListNode(num2);
        s.printListNode(listNode1);
        s.printListNode(listNode2);

        ListNode node = s.addTwoNumbers(listNode1, listNode2);
        s.printListNode(node);
    }
}
