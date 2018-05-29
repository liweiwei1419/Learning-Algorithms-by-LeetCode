import java.util.List;

// https://leetcode-cn.com/problems/binary-tree-right-side-view/description/
// 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
// 第 1 次遍历到这一层的时候，就记录，就得到
//输入: [1,2,3,null,5,null,4]
//        输出: [1, 3, 4]
//        解释:
//
//        1            <---
//        /   \
//        2     3         <---
//        \     \
//        5     4       <---

// 留做练习
public class Solution3 {

    public List<Integer> rightSideView(TreeNode root) {
        return null;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode4;

        Solution3 solution3 = new Solution3();
        List<Integer> rightSideView = solution3.rightSideView(treeNode1);
        System.out.println(rightSideView);
    }

}
