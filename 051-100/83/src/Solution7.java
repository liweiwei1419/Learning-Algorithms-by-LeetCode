class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = nums[0];
        ListNode curr = this;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val + " -> ");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

// 删除排列链表中的重复元素
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode next;
        while (cur.next != null) {
            next = cur.next;
            if (next.val == cur.val) {
                cur.next = next.next;
                next.next = null;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3};
        ListNode head = new ListNode(nums);
        Solution solution = new Solution();
        System.out.println("删除排序链表中的重复元素以后：");
        ListNode deleteDuplicates = solution.deleteDuplicates(head);
        System.out.println(deleteDuplicates);
    }
}
