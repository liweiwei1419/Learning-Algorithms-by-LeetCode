public class Solution3 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 这里设置 dummyNode 是为了处理头结点的特殊情况
        // 使得头结点和非头结点可以统一处理
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;

        while (curNode.next != null && curNode.next.next != null) {
            ListNode first = curNode.next;
            ListNode second = first.next;

            ListNode third = second.next;

            // 交换
            second.next = first;
            first.next = third;

            // 和之前 swap 的链表接上
            curNode.next = second;

            // 站在下一轮交换的结点前面
            curNode = first;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 给定 1->2->3->4, 你应该返回 2->1->4->3.
        int[] nums = {1, 2, 3, 4};
        ListNode head = new ListNode(nums);
        Solution3 solution3 = new Solution3();
        ListNode swapPairs = solution3.swapPairs(head);
        System.out.println(swapPairs);
    }
}
