class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        l = len(nums)
        if l == 0:
            return True
        max_arrive = nums[0]
        for i in range(1, l):
            if i > max_arrive:
                return False
            else:
                max_arrive = max(max_arrive, i + nums[i])
        return True


