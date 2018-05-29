// https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/


public class Solution2 {

    private int[] nums;

    private TreeNode merge(int left, int right) {
        if (left == right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = merge(left, mid);
        treeNode.right = merge(mid + 1, right);
        return treeNode;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        this.nums = nums;
        return merge(0, len);
    }

}
