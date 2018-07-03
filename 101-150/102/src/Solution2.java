import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liwei
 * @date 18/7/3 下午4:37
 */
public class Solution2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = queue.removeFirst();
                curLevel.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(curLevel);
        }
        return res;
    }
}


