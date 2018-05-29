import java.util.Stack;

// 最简洁的解法
// 1、使用栈模拟了我们手算加法的过程：先算个位，再十位；
// 2、这里计算出的结果一层一层往前面加，是我们平时不常见的，要多练习。
public class Solution3 {

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

    public static void main(String[] args) {
        // write your code here

        int[] num1 = new int[]{1, 1, 2, 3, 4, 5};
        int[] num2 = new int[]{1, 2, 3, 4, 4};
        Solution3 s = new Solution3();
        ListNode listNode1 = s.createListNode(num1);
        ListNode listNode2 = s.createListNode(num2);
        s.printListNode(listNode1);
        s.printListNode(listNode2);

        ListNode node = s.addTwoNumbers(listNode1, listNode2);
        s.printListNode(node);
    }
}
