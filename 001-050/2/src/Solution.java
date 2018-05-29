class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// https://leetcode-cn.com/problems/add-two-numbers/description/
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            sum /= 10;
        }
        if (sum == 1) {
            curr.next = new ListNode(1);
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        // write your code here

//        int[] num1 = {2, 4, 3, 1, 2};
//        int[] num2 = {5, 6, 4};

        int[] num1 = {5};
        int[] num2 = {5};


        Solution s = new Solution();
        ListNode l1 = s.createListNode(num1);
        ListNode l2 = s.createListNode(num2);

        ListNode result = s.addTwoNumbers(l1, l2);
        s.printListNode(result);


    }
}
