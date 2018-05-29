// https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/description/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    private TreeNode insert(TreeNode node, int key) {
        if (node == null) {
            return new TreeNode(key);
        }
        if (node.val < key) {
            node.right = insert(node.right, key);
            return node;
        } else if (node.val > key) {
            node.left = insert(node.left, key);
            return node;
        }
        return node;
    }


    private TreeNode merge(TreeNode node, int[] nums, int left, int right) {
        if (left == right + 1) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = merge(treeNode, nums, left, mid - 1);
        treeNode.right = merge(treeNode, nums, mid + 1, right);
        return treeNode;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        return merge(null, nums, 0, len - 1);
    }

    public static void main(String[] args) {
        // write your code here
    }
}
