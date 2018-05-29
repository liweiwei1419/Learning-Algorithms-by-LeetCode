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
// https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
public class Solution {

    private enum Command {
        GO, ADD
    }

    private class StackData {
        private Command command;
        private TreeNode treeNode;

        public StackData(Command command, TreeNode treeNode) {
            this.command = command;
            this.treeNode = treeNode;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<StackData> stack = new Stack<>();
        stack.push(new StackData(Command.GO, root));
        while (!stack.isEmpty()) {
            StackData stackData = stack.pop();
            if (stackData.command == Command.ADD) {
                result.add(stackData.treeNode.val);
            } else {
                assert stackData.command == Command.GO;
                // 特别注意：以下的顺序是与递归执行的顺序反着来的，即：倒过来写的结果。
                TreeNode node = stackData.treeNode;
                // 执行到 "go"
                if (node.right != null) {
                    stack.push(new StackData(Command.GO, node.right));
                }
                stack.push(new StackData(Command.ADD, node));
                if (node.left != null) {
                    stack.push(new StackData(Command.GO, node.left));
                }
            }
        }
        return result;
    }
}
