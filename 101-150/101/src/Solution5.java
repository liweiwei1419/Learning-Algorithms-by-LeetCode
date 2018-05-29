// 留做练习
public class Solution5 {

    public boolean isSymmetric(TreeNode root) {
        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2L = new TreeNode(2);
        TreeNode node2R = new TreeNode(2);
        TreeNode node3L = new TreeNode(3);
        TreeNode node3R = new TreeNode(3);

        node1.left = node2L;
        node1.right = node2R;

        node2L.right= node3L;
        node2R.right= node3R;

        Solution5 solution5 = new Solution5();
        boolean symmetric = solution5.isSymmetric(node1);
        System.out.println(symmetric);
    }
}
