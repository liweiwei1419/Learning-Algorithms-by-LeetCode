
// https://leetcode-cn.com/problems/remove-linked-list-elements/description/
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

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


    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode cur = dummyNode;
        while (cur.next!=null){
            if(cur.next.val==val){
                ListNode delete = cur.next;
                cur.next = delete.next;
                delete.next =null;

            }else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{6,6,6,6,6};
        Solution solution =new Solution();
        ListNode head = solution.createListNode(nums);
        solution.removeElements(head,6);
        solution.printListNode(head);

    }
}
