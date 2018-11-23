# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):

    # 使用哈希表的方法查重肯定是可以的，但并不推荐

    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """

        if head is None:
            return False

        hash_tabel = dict()

        point = head

        while point:

            if point in hash_tabel:
                return True
            else:
                hash_tabel[point] = 0
            point = point.next
        return False
