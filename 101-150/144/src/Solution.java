import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 144. 二叉树的前序遍历
// https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
public class Solution {

    private List<Integer> res = new ArrayList<>();

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return res;
    }


    public static void main(String[] args) {
        // write your code here
    }
}
