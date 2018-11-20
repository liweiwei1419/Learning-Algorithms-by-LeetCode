class Solution:
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """

        if len(s) != len(t):
            return False

        arr_s = []
        for char in s:
            arr_s.append(char)

        arr_t = []
        for char in t:
            arr_t.append(char)

        arr_s.sort()
        arr_t.sort()

        for char_s, char_t in zip(arr_s, arr_t):
            if char_s != char_t:
                return False
        return True


if __name__ == '__main__':
    s = "anagram"
    t = "nagaram"

    solution = Solution()
    result = solution.isAnagram(s, t)
    print(result)
