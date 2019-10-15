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

public class Solution {

    public ListNode partition(ListNode head, int x) {
        // 比 x 小的虚拟头结点
        ListNode dummyNodeL = new ListNode(-1);
        // 大于等于 x 的虚拟头结点
        ListNode dummyNodeR = new ListNode(-1);
        // 用于遍历
        ListNode curL = dummyNodeL;
        // 用于遍历
        ListNode curR = dummyNodeR;
        int val;
        while (head != null) {
            val = head.val;
            // 接在 L 的后面
            if (val < x) {
                curL.next = new ListNode(val);
                curL = curL.next;
            } else {
                // 接在 R 的后面
                curR.next = new ListNode(val);
                curR = curR.next;
            }
            head = head.next;
        }
        // 把较小的链表接在较大的链表后面
        curL.next = dummyNodeR.next;
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
