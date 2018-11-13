/**
 * 不想穿针引线，那就递归来做这件事情吧
 *
 * @author liwei
 */
public class Solution2 {

    /**
     * 反转一个单链表
     * 步骤：先写递归终止条件，然后假设规模小一个级别的问题解决了，思考如何与原规模的问题建立联系
     *
     * @param head 单链表的头结点
     * @return 反转以后单链表的头结点
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 其实这一步做的也是穿针引线的工作了
        ListNode nextNode = head.next;
        ListNode reverseList = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return reverseList;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        Solution2 solution2 = new Solution2();
        ListNode reverseList = solution2.reverseList(head);
        System.out.println("反转之后");
        System.out.println(reverseList);
    }
}
