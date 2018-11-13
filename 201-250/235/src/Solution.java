class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        // 其实这一步判断可以不用
        if (root == null || root == p || root == q) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor1(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor1(root.right, p, q);
        }
        return root;
    }
}
