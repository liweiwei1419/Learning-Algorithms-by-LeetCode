

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// https://leetcode-cn.com/problems/count-complete-tree-nodes/description/
public class Solution {

    private int depth(TreeNode root, boolean isLeft) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = isLeft ? root.left : root.right;
        }
        return depth;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = depth(root, true);
        int rightDepth = depth(root, false);
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public static void main(String[] args) {
        System.out.println(2 << 1);
    }

}
