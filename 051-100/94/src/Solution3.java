import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liwei
 * @date 18/7/3 下午5:55
 */
public class Solution3 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.add(p);
                p = p.left;
            }
            TreeNode top = stack.pop();
            res.add(top.val);
            p = top.right;
        }
        return res;
    }
}
