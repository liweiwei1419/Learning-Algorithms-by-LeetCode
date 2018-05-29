


// 给定一个二叉搜索树，编写一个函数kthSmallest来查找其中第 k 个最小的元素。
// 只要利用二分搜索树的中序遍历，就可以完成。
public class Solution3 {

    private int count = 0;
    private int k;
    private int res;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            // 什么都不做
            return;
        }
        inOrder(node.left);

        // BST 的中序遍历，就在这里做操作
        count++;
        if (count == k) {
            res = node.val;
            return;
        }

        inOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(15);
        TreeNode treeNode3 = new TreeNode(20);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        Solution3 solution3 = new Solution3();
        int kthSmallest = solution3.kthSmallest(treeNode2, 2);
        System.out.println(kthSmallest);
    }
}
