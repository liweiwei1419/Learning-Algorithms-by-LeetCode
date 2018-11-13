
// https://leetcode-cn.com/problems/binary-tree-paths/description/
// 我的第一感觉是使用深度优先遍历，遍历到根节点的时候，计算一个结果。
// 一定要设立一个辅助函数，这个辅助函数的第 2 个参数是一个栈。

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


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


    private void dfs(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        // node 不为空的时候
        if (node.left == null && node.right == null) {
            // 是叶子节点，输出结果
            result.add(path + node.val);
            return;
        }
        if (node.left != null) {
            dfs(node.left, path + node.val + "->");
        }

        if (node.right != null) {
            dfs(node.right, path + node.val + "->");
        }

    }

    public List<String> binaryTreePaths(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        dfs(root, "");
        return result;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
