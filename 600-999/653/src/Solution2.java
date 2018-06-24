import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author liwei
 * @date 18/6/22 下午2:18
 */
public class Solution2 {

    // 哈希表的方式，其实前中后序都能通过，甚至层序遍历也行
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        boolean[] res = new boolean[1];
        preOrder(root, set, k, res);
        return res[0];
    }

    private void preOrder(TreeNode node, HashSet<Integer> set, int k, boolean[] res) {
        if (node == null) {
            return;
        }
        // 2 * node.val == k 的情况，因为 BST 中，所有的数都不相同
        if (set.contains(k - node.val) && 2 * node.val != k) {
            res[0] = true;
            return;
        } else {
            set.add(node.val);
        }
        preOrder(node.left, set, k, res);
        preOrder(node.right, set, k, res);
    }
}
