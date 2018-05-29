package leetcode.q94;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归实现中序遍历
 * Created by liwei on 17/9/25.
 */
public class Solution2 {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            result.add(root.val);
            inorder(root.right);
        }
    }
}
