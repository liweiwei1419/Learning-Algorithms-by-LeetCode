
class Solution2 {

    // 这是一个递归方法，首先处理递归到底的情况
    public ListNode removeElements(ListNode head, int val) {
        // 首先处理递归到底的情况
        if (head == null) {
            return head;
        }
        // 把一个问题转化为规模更小的问题
        ListNode res = removeElements(head.next, val);
        // 下面处理原始规模的问题如何与小规模的问题建立联系
        if (head.val == val) {
            // 当前这个节点必须要被删掉
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        int val = 6;
        Solution solution = new Solution();
        ListNode removeElements = solution.removeElements(head, val);
        System.out.println(removeElements);
    }
}
