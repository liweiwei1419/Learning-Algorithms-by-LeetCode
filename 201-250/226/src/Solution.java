
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {


    // 使用前序遍历
    // 递归求解二叉树的问题，往往先处理节点为 null 的情况，可以减少很多为 null 的判断。

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 左子树和右子树交换，即使左右子树都空也不影响正确性
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归翻转左右子树
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
