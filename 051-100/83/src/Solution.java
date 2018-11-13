class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] nums) {
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
        // 最后添加一个 NULL 标志表示添加到末尾了
        s.append("NULL");
        return s.toString();
    }
}

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/
 *
 * @author liwei
 */
public class Solution {


    /**
     * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
     * 头结点肯定不会被删除，故可以不用设置虚拟头结点。
     *
     * @param head 待删除重复元素的单链表
     * @return 删除重复元素以后的单链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curNode = head;
        while (curNode != null && curNode.next != null) {
            if (curNode.val == curNode.next.val) {
                ListNode delNode = curNode.next;
                // 继续向前找，看看，还有没有可以删除的结点
                while (delNode.next != null && delNode.next.val == delNode.val) {
                    delNode = delNode.next;
                }
                // 穿针引线
                curNode.next = delNode.next;
                delNode.next = null;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 3, 3};
        ListNode head = new ListNode(nums);
        Solution solution = new Solution();
        ListNode deleteDuplicates = solution.deleteDuplicates(head);
        System.out.println(deleteDuplicates);
    }
}
