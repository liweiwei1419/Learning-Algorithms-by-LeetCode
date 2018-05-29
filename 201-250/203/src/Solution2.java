public class Solution2 {

    public ListNode createListNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    public void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println(" NULL ");
    }


    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        // 假设小一个规模的问题已经解决
        head.next = removeElements(head.next,val);

        if(head.val==val){
            return head.next;
        }else {
            return head;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{6,2,6,3,5};
        Solution2 solution =new Solution2();
        ListNode head = solution.createListNode(nums);



        solution.printListNode(head);
        ListNode node = solution.removeElements(head, 6);

        System.out.println("删除以后");


        solution.printListNode(node);
    }


}
