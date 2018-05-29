class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
// https://leetcode-cn.com/problems/invert-binary-tree/description/
// 简单
// 递归求解二叉树的问题，往往先处理节点为 null 的情况，可以减少很多为 null 的判断。
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
