package leetcode.q206;

/**
 * 题目简介：链表翻转
 * Created by liwei on 17/9/14.
 */

import java.util.List;

/**
 * 单链表
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curNode = head;

        // 注意，是当前的 curNode 不为空
        while (curNode!=null){
            // 先保存下一个节点的引用，是为了当前指针后移
            ListNode next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
        }
        return pre;
    }
}

