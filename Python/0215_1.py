import heapq


# 还可以参考：https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/167837/Python-or-tm

class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        L = []
        for index in range(k):
            heapq.heappush(L, nums[index])
        for index in range(k, len(nums)):
            top = L[0]
            if nums[index] > top:
                heapq.heapreplace(L, nums[index])
        return L[0]


if __name__ == '__main__':
    nums = [3, 7, 8, 1, 2, 4]
    solution = Solution()
    result = solution.findKthLargest(nums, 2)
    print(result)
