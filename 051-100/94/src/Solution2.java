package leetcode.q94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by liwei on 17/9/16.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

enum UseType {
    RECURSION,
    ADD
}

class Command {
    UseType useType;
    TreeNode treeNode;

    Command(UseType useType, TreeNode treeNode) {
        this.useType = useType;
        this.treeNode = treeNode;
    }
}

/**
 * 什么是中序遍历，先递归遍历左子节点
 * 在处理自己
 * 然后再递归遍历右子节点
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command(UseType.RECURSION, root));

        while (!stack.isEmpty()) {
            Command command = stack.pop();
            if (UseType.ADD == command.useType) {
                result.add(command.treeNode.val);
            } else {
                assert UseType.RECURSION == command.useType;
                if (command.treeNode.right != null) {
                    stack.push(new Command(UseType.RECURSION, command.treeNode.right));
                }
                stack.push(new Command(UseType.ADD, command.treeNode));
                if (command.treeNode.left != null) {
                    stack.push(new Command(UseType.RECURSION, command.treeNode.left));
                }
            }

        }
        return result;
    }
}
