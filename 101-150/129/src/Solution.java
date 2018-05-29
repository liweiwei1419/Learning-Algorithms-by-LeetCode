// https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/description/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 我的思路：使用深度优先遍历，遍历到根节点的时候，把数字加一加
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    private List<String> result = new ArrayList<>();

    private void sumNumbers(TreeNode node, String path) {
        if (node == null) {
            return;
        }

        path = path + node.val;
        if (node.left == null && node.right == null) {
            // 才是叶子节点，执行我们的逻辑
            result.add(path);
            return;
        }
        sumNumbers(node.left, path);
        sumNumbers(node.right, path);
    }

    private int convert() {
        int sum = 0;
        for (String s : result) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumNumbers(root, "");
        return convert();
    }

    public static void main(String[] args) {
        // write your code here

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;

        Solution solution = new Solution();
        int result = solution.sumNumbers(n1);
        System.out.println("得到的结果：" + result);
    }
}
