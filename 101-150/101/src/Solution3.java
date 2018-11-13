import java.util.LinkedList;

// https://leetcode-cn.com/problems/symmetric-tree/description/
public class Solution3 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.addFirst(root.left);
        linkedList.addLast(root.right);
        while (!linkedList.isEmpty()) {
            // 出队的时候，看看是否有左右孩子，分别入队
            TreeNode lNode = linkedList.removeFirst();
            TreeNode rNode = linkedList.removeLast();
            if (lNode == null && rNode == null) {
                continue;
            }
            if (lNode == null || rNode == null) {
                return false;
            }
            linkedList.addFirst(lNode.right);
            linkedList.addFirst(lNode.left);
            linkedList.addLast(rNode.left);
            linkedList.addLast(rNode.right);

            if (lNode.val != rNode.val) {
                return false;
            }
        }
        return true;
    }
}
