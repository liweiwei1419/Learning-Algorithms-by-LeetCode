/**
 * @author liwei
 * @date 18/7/3 下午6:10
 */
public class Solution2 {

    // 使用后序遍历

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
