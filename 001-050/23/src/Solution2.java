import java.util.PriorityQueue;

// 参考资料：https://zhuanlan.zhihu.com/p/33050219
public class Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(len, (a, b) -> a.val - b.val);
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            curNode.next = new ListNode(node.val);
            // 这一步千万不要忘记了
            // 这一步千万不要忘记了
            // 这一步千万不要忘记了
            curNode = curNode.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummyNode.next;
    }


}
