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

/**
 * 参考资料：
 * https://leetcode-cn.com/articles/remove-nth-node-from-end-of-list/
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * @author liwei
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        // 要走 n 步
        while (curNode != null && n != -1) {
            curNode = curNode.next;
            n--;
        }
        ListNode pre = dummyNode;
        while (curNode != null) {
            pre = pre.next;
            curNode = curNode.next;
        }
        // 走到这里 curNode == null ，即 来到了链表的尾结点
        // 并且 pre 来到了要删除结点的下一个结点
        ListNode deleteNode = pre.next;
        pre.next = deleteNode.next;
        deleteNode.next = null;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        int n = 2;
        ListNode head = new ListNode(nums);
        Solution solution = new Solution();
        ListNode removeNthFromEnd = solution.removeNthFromEnd(head, n);
        System.out.println(removeNthFromEnd);
    }
}
