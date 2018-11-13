public class Solution2 {

    private int res;
    private int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return res;
    }

    private void dfs(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        dfs(node.left, k);
        // BST 的中序遍历，就在这里做操作
        count++;
        if (count == k) {
            res = node.val;
            return;
        }
        dfs(node.right, k);
    }
}
