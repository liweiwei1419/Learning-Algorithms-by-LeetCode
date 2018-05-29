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

public class Solution {

    private List<Integer> result = new ArrayList<>();

    private void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        result.add(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return result;
    }


    public static void main(String[] args) {
        // write your code here
    }
}
