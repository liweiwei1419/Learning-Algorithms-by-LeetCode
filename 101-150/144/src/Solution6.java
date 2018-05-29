import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
public class Solution2 {


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

    public List<Integer> preorderTraversal(TreeNode root) {
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
                if (node.left != null) {
                    stack.push(new StackData(Command.GO, node.left));
                }
                stack.push(new StackData(Command.ADD, node));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        // write your code here

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);

        n3.left = n1;
        n3.right = n2;
        Solution2 solution2 = new Solution2();
        List<Integer> preorderTraversal = solution2.preorderTraversal(n3);
        System.out.println(preorderTraversal);
    }
}
