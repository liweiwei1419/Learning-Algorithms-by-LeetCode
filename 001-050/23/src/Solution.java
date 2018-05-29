
import java.util.*;

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

//        // 把一个数组转化为 ListNode
//        int[] nums = {3,4,5,6,7};
//        ListNode head = new ListNode(nums);
//        System.out.println(head);

// 我的思路：其实很简单，应用我们生活中的经验就可以完成这个问题：
// 假设有 3 个队伍，即 3 列学生，站在你面前，每一列学生都按照身高从矮到高排列，我们要将他们合成一列，并且也是从矮到高
// 我们只需要每一次将 3 列站在队首的那个学生比一下，让最矮的学生出列，出列的那一对次矮的同学往前走一步，继续参与比较
// 构建一个只有 ListNode 数组元素个数的最小堆
// 其实思路很简单，使用优先队列的最小堆实现
// 入优先队列的时候，入元素和所在的组别号
// 出优先队列的时候，除了元素添加到结果意外，从所对应的组别号中加入一个元素
// 这里要注意处理很多细节问题，主要是：1、ListNode 数组为空的时候；
// 2、指针的移动，例如：
//ListNode(Integer[] nums) {
//    ListNode currNode = this;
//    currNode.val = nums[0];
//    for (int i = 1; i < nums.length; i++) {
//        currNode.next = new ListNode(nums[i]);
//        currNode = currNode.next;
//    }
//}

// 3、只有队列非空的时候，才出队列，ListNode 元素的 next 非空的时候，才取其 val。
// https://leetcode-cn.com/problems/merge-k-sorted-lists/description/

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer[]> queue = new PriorityQueue(3, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });
        int count = 0;
        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            if (curr != null) {
                queue.add(new Integer[]{curr.val, i});
                curr = curr.next;
                lists[i] = curr;
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        Integer[] currentMinElement;
        ListNode nextInQueueNode;
        int nextInQueueIndex;
        while (!queue.isEmpty()) {
            currentMinElement = queue.poll();
            result.add(currentMinElement[0]);
            nextInQueueIndex = currentMinElement[1];
            nextInQueueNode = lists[nextInQueueIndex];
            if (nextInQueueNode != null) {
                queue.add(new Integer[]{nextInQueueNode.val, currentMinElement[1]});
                lists[nextInQueueIndex] = nextInQueueNode.next;
            }
        }
        ListNode head = new ListNode(result.get(0));
        ListNode currNode = head;
        int size = result.size();
        for (int i = 1; i < size; i++) {
            currNode.next = new ListNode(result.get(i));
            currNode = currNode.next;
        }
        return head;
    }


    public static void main(String[] args) {

        Integer[] nums1 = {1, 4, 5};
        Integer[] nums2 = {1, 3, 4};
        Integer[] nums3 = {2, 6};
        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);
        ListNode head3 = new ListNode(nums3);

        ListNode[] lists = new ListNode[3];
//        lists[0]=head1;
//        lists[1]=head2;
//        lists[2]=head3;
        ListNode node = new Solution().mergeKLists(lists);
        System.out.println(node);
    }
}
