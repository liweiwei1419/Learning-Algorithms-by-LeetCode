# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        pre = None
        cur = head
        while cur is not None:
            next_temp = cur.next
            cur.next = pre
            pre = cur
            cur = next_temp
        return pre
