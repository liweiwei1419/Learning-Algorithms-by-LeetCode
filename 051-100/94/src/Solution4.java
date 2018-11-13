import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution4 {

    // 左结点一直入栈，然后出栈的时候，当前结点有右边结点的就变成右边结点。

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            // 直到 p 为空
            TreeNode node = stack.pop();
            res.add(node.val);
            p = node.right;
        }
        return res;
    }
}
