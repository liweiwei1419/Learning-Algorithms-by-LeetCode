import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// https://leetcode-cn.com/problems/path-sum-ii/description/

public class Solution {

    List<List<Integer>> result = new ArrayList<>();

    // 如果使用链表的话，一定要使用 addLast 和 removeLast
    // 如果使用 push 和 poll 相应的会在链表的头部操作，就不是我们的本意了

    public void pathSum(TreeNode node, int sum, LinkedList<Integer> stack) {
        if (node == null) {
            return;
        }
        stack.addLast(node.val);
        if (node.left == null && node.right == null) {
            // 就是根节点了，返回
            if (node.val == sum) {
                result.add(new ArrayList<>(stack));
            }
        }
        pathSum(node.left, sum - node.val, stack);
        pathSum(node.right, sum - node.val, stack);
        stack.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        pathSum(root, sum, new LinkedList<>());
        return result;
    }
}
