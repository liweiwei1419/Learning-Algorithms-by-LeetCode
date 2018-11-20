class Solution:
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """

        result = []
        # Python 中的 set 有一个 __contains__ 方法，用起来不太好看，所以就 dict
        s = set()
        for num in nums1:
            s.add(num)

        for num in nums2:
            if s.__contains__(num):
                result.append(num)
                # 用完马上删掉，就可以避免重复问题了
                s.remove(num)

        return result


if __name__ == '__main__':
    nums1 = [4, 9, 5]
    nums2 = [9, 4, 9, 8, 4]
    s = Solution()
    result = s.intersection(nums1, nums2)
    print(result)
