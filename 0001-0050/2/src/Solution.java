class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int[] nums) {
        this.val = nums[0];
        ListNode curNode = this;
        for (int i = 1; i < nums.length; i++) {
            curNode.next = new ListNode(nums[i]);
            curNode = curNode.next;
        }
    }

    @Override
    public String toString() {
        ListNode curNode = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (curNode != null) {
            stringBuilder.append(curNode.val);
            stringBuilder.append(" -> ");
            curNode = curNode.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }
}


public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            curNode.next = new ListNode(sum % 10);
            sum /= 10;
            curNode = curNode.next;
        }
        if (sum == 1) {
            curNode.next = new ListNode(1);
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{5};
        int[] nums2 = new int[]{5};
        ListNode l1 = new ListNode(nums1);
        ListNode l2 = new ListNode(nums2);
        Solution solution = new Solution();
        ListNode addTwoNumbers = solution.addTwoNumbers(l1, l2);
        System.out.println(addTwoNumbers);
    }
}

