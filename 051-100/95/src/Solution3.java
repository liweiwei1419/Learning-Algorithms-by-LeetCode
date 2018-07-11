import java.util.ArrayList;
import java.util.List;

public class Solution3 {

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
            // 这个位置一定要占住
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTrees(start, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, end);
            for (TreeNode l : leftList) {
                for (TreeNode r : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {

        List<TreeNode> res = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            res.add(null);
        }


        System.out.println(res);

    }


}
