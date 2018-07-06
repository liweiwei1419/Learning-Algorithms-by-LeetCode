/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
public class Solution3 {

    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        int l = 0;
        int r = len - 1;
        return sortedArrayToBST(nums, l, r);
    }

    private TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        // 递归终止的条件要先写
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, l, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, r);
        return root;
    }
}
