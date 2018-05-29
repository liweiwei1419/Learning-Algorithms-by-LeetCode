

// https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/description/
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
        count++;
        if (count == k) {
            res = node.val;
            return;
        }
        dfs(node.right, k);
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(15);
        TreeNode treeNode3 = new TreeNode(20);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        Solution2 s = new Solution2();
        int kthSmallest = s.kthSmallest(treeNode2, 2);
        System.out.println(kthSmallest);
    }
}
