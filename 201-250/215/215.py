# @Time    : 18/4/8 下午3:59
# @Author  : liweiwei1419
# @Site    : http://www.liwei.party/
# @Contact : liweiwei1419@gmail.com


class Solution:
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        n = len(nums)
        begin = 0
        end = n - 1
        while True:
            index = self._partition(nums, begin, end)
            if index == n - k:
                return nums[index]
            elif index < n - k:
                begin = index + 1
            else:
                end = index - 1

    def _partition(self, nums, begin, end):
        p = nums[begin]
        j = begin
        for i in range(begin + 1, end + 1):
            if nums[i] >= p:
                pass
            else:  # 严格小于
                j += 1
                self._swap(nums, j, i)
        self._swap(nums, begin, j)
        return j

    def _swap(self, nums, index1, index2):
        if index1 == index2:
            return
        temp = nums[index1]
        nums[index1] = nums[index2]
        nums[index2] = temp


if __name__ == '__main__':
    nums = [4, 8, 2, 5, 1, 6, 7, 10, 19, 13, 3]
    val = sorted(nums)
    s = Solution()
    for k in range(1, len(nums) + 1):
        res = s.findKthLargest(nums, k)
        print('验证！！！')
        l = len(nums)
        print(res, val[l - k])
