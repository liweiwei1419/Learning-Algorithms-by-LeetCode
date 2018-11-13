/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 * 这道题是一道常规问题，画图分析，依然是解决这一类问题的关键
 *
 * @author liwei
 */
public class Solution2 {

    // 本质上和 Solution 是一样的，但是语义没有 Solution 清晰

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        int p;
        ListNode post;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                // 接来下的两个节点值相等，就要处理一些逻辑了
                post = cur.next;
                // 把等于 p 的节点全部删光
                p = post.val;
                while (post.next != null && post.next.val == p) {
                    // post 向前走一步
                    ListNode deleteNode = post;
                    post = post.next;
                    deleteNode.next = null;
                }
                cur.next = post.next;
                post.next = null;
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        // 1->2->3->3->4->4->5
        // int[] nums = {1, 2, 3, 3, 4, 4, 5};
        int[] nums = {1, 1, 1, 2, 3};
        Solution solution = new Solution();
        ListNode listNode = new ListNode(nums);
        ListNode deleteDuplicates = solution.deleteDuplicates(listNode);
        System.out.println(deleteDuplicates);
    }
}
