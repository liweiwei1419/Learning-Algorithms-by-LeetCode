
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
// https://leetcode-cn.com/problems/delete-node-in-a-linked-list/description/
public class Solution {

    //   3
    // 1 3 5 7
    // 指向它下一节点的下一个节点
    // 把下一个节点的值复制给自己

    public void deleteNode(ListNode node) {
        // 因为题目已经明确说了，不是最后一个节点，因此 node.next 一定非空
        ListNode next = node.next;
        node.next = next.next;
        node.val = next.val;
        next.next = null;
    }

    public static void main(String[] args) {
        // write your code here

        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        Solution s = new Solution();
        s.deleteNode(node1);


    }
}
