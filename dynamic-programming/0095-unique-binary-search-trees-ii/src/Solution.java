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

    // 分治思想

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
            // 上层调用的方法须要这个空结点作为其左结点或者右节点
            res.add(null);
            return res;
        } else if (start == end) {
            // 只有一个结点，这个结点作为根结点返回即可
            // 这一步可以包括到下面一个情况中
            res.add(new TreeNode(start));
            return res;
        } else {
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftList = generateTrees(start, i - 1);
                List<TreeNode> rightList = generateTrees(i + 1, end);
                for (TreeNode leftTree : leftList) {
                    for (TreeNode rightTree : rightList) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        res.add(root);
                    }
                }
            }
        }
        return res;
    }
}