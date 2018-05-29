
// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 初始条件：只要等于其中之一，就返回自己，作为后序判断的依据
        if (root == null || root == p || root == q) {
            return root;
        }
        root.left = lowestCommonAncestor(root.left, p, q);
        root.right = lowestCommonAncestor(root.right, p, q);

        if (root.left != null && root.right != null) {
            return root;
        }
        // 走到这里，必定 root.left 和 root.right 其中之一为 null
        return root.right == null ? root.left : root.right;
    }


    public static void main(String[] args) {
        // write your code here
    }
}
