// 使用递归方法完成
public class Solution2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 先写递归终止的条件
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 假设规模小的问题已经解决，如何建立和原始规模问题之间的关系
        ListNode mergeNode;
        if (l1.val < l2.val) {
            mergeNode = l1; // l1 被选出，谁小谁在前面
            mergeNode.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeNode = l2; // l2 被选出，谁小谁在前面
            mergeNode.next = mergeTwoLists(l1, l2.next);
        }
        return mergeNode;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 6};

        ListNode l1 = new ListNode(nums1);
        ListNode l2 = new ListNode(nums2);

        Solution2 solution2 = new Solution2();
        ListNode mergeTwoLists = solution2.mergeTwoLists(l1, l2);
        System.out.println(mergeTwoLists);
    }
}
