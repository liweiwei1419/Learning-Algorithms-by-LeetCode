
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(Integer[] nums) {
        ListNode currNode = this;
        currNode.val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currNode.next = new ListNode(nums[i]);
            currNode = currNode.next;
        }
    }

    @Override
    public String toString() {
        ListNode currNode = this;
        StringBuilder s = new StringBuilder();
        while (currNode != null) {
            s.append(currNode.val);
            s.append(" -> ");
            currNode = currNode.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/description/
 *
 * @author liwei
 */
public class Solution {

    //   3
    // 1 3 5 7
    // 指向它下一节点的下一个节点
    // 把下一个节点的值复制给自己
    public void deleteNode(ListNode node) {
        // 因为题目已经明确说了，不是最后一个节点，因此 node.next 一定非空
        ListNode deleteNode = node.next;
        node.val = deleteNode.val;
        node.next = deleteNode.next;
        deleteNode.next = null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        Solution s = new Solution();
        s.deleteNode(node1);
    }
}
