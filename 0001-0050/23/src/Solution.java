import java.util.Comparator;
import java.util.PriorityQueue;

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
        // 最后添加一个 NULL 标志表示添加到末尾了
        s.append("NULL");
        return s.toString();
    }
}


/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 * 参考资料：https://zhuanlan.zhihu.com/p/33050219
 *
 * 优先队列的写法：推荐
 *
 * @author liwei
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        Comparator<ListNode> comparator = (a, b) -> a.val - b.val;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(comparator);
        for (int i = 0; i < len; i++) {
            // 注意：这里要注意到测试用例中，ListNode 为 null 的特殊情况，空节点是一定不能放入优先队列的，把空节点放入优先队列没有意义
            if (lists[i] != null) {
                priorityQueue.add(lists[i]);
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        while (!priorityQueue.isEmpty()) {
            ListNode curMin = priorityQueue.poll();
            cur.next = curMin;
            cur = cur.next;
            if (curMin.next != null) {
                priorityQueue.add(curMin.next);
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        Integer[] nums1 = {1, 4, 5};
        Integer[] nums2 = {1, 3, 4};
        Integer[] nums3 = {2, 6};
        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);
        ListNode head3 = new ListNode(nums3);
        ListNode[] lists = new ListNode[3];
        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;
        Solution solution = new Solution();
        ListNode mergeKLists = solution.mergeKLists(lists);
        System.out.println(mergeKLists);
    }
}
