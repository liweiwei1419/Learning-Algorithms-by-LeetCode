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

// https://leetcode-cn.com/problems/partition-list/description/
// 思路：创建两个 ListNode ，分别去接遍历到的元素，然后拼在一起。
public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode dummyNodeL = new ListNode(-1); // 比 x 小的虚拟头结点
        ListNode dummyNodeR = new ListNode(-1); // 大于等于 x 的虚拟头结点
        ListNode curL = dummyNodeL; // 用于遍历
        ListNode curR = dummyNodeR; // 用于遍历
        int val;
        while (head != null) {
            val = head.val;
            if (val < x) { // 接在 L 的后面
                curL.next = new ListNode(val);
                curL = curL.next;
            } else { // 接在 R 的后面
                curR.next = new ListNode(val);
                curR = curR.next;
            }
            head = head.next;
        }
        curL.next = dummyNodeR.next; // 把较小的链表接在较大的链表后面
        return dummyNodeL.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 2};
        int x = 3;
        ListNode head = new ListNode(nums);
        Solution solution = new Solution();
        System.out.println("分隔链表之后：");
        ListNode partition = solution.partition(head, x);
        System.out.println(partition);
    }
}
