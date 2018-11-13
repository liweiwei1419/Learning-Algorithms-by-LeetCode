// 同 Solution1 只是写法不一样
public class Solution3 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Integer.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
