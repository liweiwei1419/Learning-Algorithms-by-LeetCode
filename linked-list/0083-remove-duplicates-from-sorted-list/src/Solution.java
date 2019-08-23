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

// 我觉得就是细心一点，把穿针引线的细节考虑到
// 因为第 1 个结点不会被删除，因此，不用设置虚拟结点
// 1 -> 1 -> 1 -> 1 -> 2
// cur  del       del

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        // 当前和下一个结点都非空的时候才删除
        while (curNode != null && curNode.next != null) {
            // 值相同的时候考虑删除
            if (curNode.val == curNode.next.val) {
                ListNode deleteNode = curNode.next;
                // 看看是否还可以删除
                while (deleteNode.next != null && deleteNode.val == deleteNode.next.val) {
                    deleteNode = deleteNode.next;
                }
                // 穿针引线
                curNode.next = deleteNode.next;
                deleteNode.next = null;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }
}