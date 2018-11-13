class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    // 举出具体例子来分析就会很清晰，这里一定要分析清楚索引的起始
    // 例如：
    // pre: A B D E H I C F K G
    // in : D B H E I A F K C G

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        return helper(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }


    private TreeNode helper(int[] preorder,
                            int preL, int preR,
                            int[] inorder,
                            int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        int rootVal = preorder[preL];
        int l = inL;
        while (l <= inR && inorder[l] != rootVal) {
            l++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, preL + 1, preL + l - inL, inorder, inL, l - 1);
        root.right = helper(preorder, preL + l - inL + 1, preR, inorder, l + 1, inR);
        return root;
    }
}