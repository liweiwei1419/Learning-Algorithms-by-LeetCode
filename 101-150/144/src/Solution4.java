import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 144. 二叉树的前序遍历
// https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
public class Solution4 {

    private class Command {
        private String command; // 指令，只能是 go 或者是 add
        private TreeNode data; // 保存在栈中的数据

        public Command(String command, TreeNode data) {
            this.command = command;
            this.data = data;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Command> stack = new Stack<>();
        stack.add(new Command("go", root));
        while (!stack.isEmpty()) {
            Command command = stack.pop();
            String curCommand = command.command;
            TreeNode curNode = command.data;
            if ("add".equals(curCommand)) {
                res.add(curNode.val);
            } else {// "go".equals(command.command)
                // 倒过来添加
                if (curNode.right != null) {
                    stack.add(new Command("go", curNode.right));
                }
                if (curNode.left != null) {
                    stack.add(new Command("go", curNode.left));
                }
                stack.add(new Command("add", curNode));
            }
        }
        return res;
    }
}
