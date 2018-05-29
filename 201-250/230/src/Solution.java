class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/description/
public class Solution {

    private int count = 0;
    private int res = 0;

    private void dfs(TreeNode node) {
        if (node == null) {
            // 什么都不做
            return;
        }
        dfs(node.left);
        count--;
        if (count == 0) {
            this.res = node.val;
        }
        dfs(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        Solution s = new Solution();
        int kthSmallest = s.kthSmallest(treeNode, 1);
        System.out.println(kthSmallest);
    }
}
