class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """

        if len(digits) == 0:
            return []
        # 进位标识
        carry = 1

        for i in range(len(digits) - 1, -1, -1):

            s = digits[i] + carry
            digits[i] = s % 10
            # 注意：整除要使用 //
            carry = s // 10

            if carry == 0:
                return digits
        print(digits, carry)

        if carry == 1:
            return [1] + digits


if __name__ == '__main__':
    digits = [9, 9, 9, 9]
    solution = Solution()
    result = solution.plusOne(digits)
    print(result)
