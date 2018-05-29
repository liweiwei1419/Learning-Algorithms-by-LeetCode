package leetcode.q145;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwei on 17/9/25.
 */
public class Solution2 {

    private List<Integer> result = new ArrayList<>();

    /**
     * 递归的方式后续遍历二叉树
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return result;

    }

    private void postorder(TreeNode root) {
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            result.add(root.val);
        }
    }
}
