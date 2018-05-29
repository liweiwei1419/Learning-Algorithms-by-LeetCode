
// 仅仅只是练习
// 思路很简单：先翻转左子树，再翻转右子树，再交换它们
// 递归思想的应用
public class Solution2 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }


}
