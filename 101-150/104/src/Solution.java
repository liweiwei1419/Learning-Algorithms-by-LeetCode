
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {

    /**
     * 首先要明确递归函数要做什么事情，参数的意义是什么，返回值的意义是什么？
     * 然后：1、想清楚递归终止条件是什么；2、递归过程是什么
     *
     * @param root 一个二叉树的根节点
     * @return 以 root 为根节点的二叉树的高度
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 下面是 root 不为 null 的情况
        int leftDepth = 0;
        if (root.left != null) {
            leftDepth = maxDepth(root.left);
        }
        int rightDepth = 0;
        if (root.right != null) {
            rightDepth = maxDepth(root.right);
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }

}
