
/**
 * 这行算法的思路最像老师介绍的 partition 的过程
 * 参考了下面的解答：
 * http://blog.csdn.net/mnmlist/article/details/43535377
 *
 * Created by liwei on 17/9/14.
 */
public class Solution4 {

    public ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode little_start = new ListNode(-1);
        ListNode little_end = little_start;

        ListNode big_start = new ListNode(-1);
        ListNode big_end = big_start;

        // 头结点
        ListNode pListNode = head;
        while (pListNode != null) {
            if (pListNode.val < x) {
                little_end.next = pListNode;
                little_end = pListNode;
            } else {
                big_end.next = pListNode;
                big_end = pListNode;
            }
            pListNode = pListNode.next;
        }

        // 创建的 DummyNode 节点要向后挪动一位
        little_start = little_start.next;
        big_start = big_start.next;

        if (little_start != null) {
            big_end.next = null;
            little_end.next = big_start;
            return little_start;
        } else {
            return big_start;
        }
    }

}
