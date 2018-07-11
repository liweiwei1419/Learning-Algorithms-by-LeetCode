import java.util.ArrayList;
import java.util.List;

/**
 * 典型的使用分治思想解决的问题
 */
public class Solution2 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            // 这个位置要占住
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            for (TreeNode l : generateTrees(start, i - 1)) {
                for (TreeNode r : generateTrees(i + 1, end)) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}