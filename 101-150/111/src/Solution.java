class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 * 111. 二叉树的最小深度
 *
 * @author liwei
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 这一步要特别注意，是一个很容易被忽略的情况
        if (root.left == null || root.right == null) {
            return Integer.max(minDepth(root.left), minDepth(root.right)) + 1;

        }
        return Integer.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
