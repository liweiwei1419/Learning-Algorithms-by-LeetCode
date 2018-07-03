/**
 * @author liwei
 * @date 18/7/3 下午4:28
 */
public class Solution4 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
