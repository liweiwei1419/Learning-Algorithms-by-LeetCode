class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {

    private boolean dfs(TreeNode node, int val, boolean ifLeft) {
        if (node == null) {
            return true;
        }
        if (ifLeft) {
            if (node.val >= val) {
                return false;
            }
            return dfs(node.left, val, true) && dfs(node.right, val, true);
        } else {
            if (node.val <= val) {
                return false;
            }
            return dfs(node.left, val, false) && dfs(node.right, val, false);
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.val, true) &&
                dfs(root.right, root.val, false) &&
                isValidBST(root.left) && isValidBST(root.right);
    }
}
