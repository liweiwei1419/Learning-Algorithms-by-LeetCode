class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        :type obstacleGrid: List[List[int]]
        :rtype: int
        """

        m = len(obstacleGrid)
        if m == 0:
            return 0
        n = len(obstacleGrid[0])

        if obstacleGrid[0][0] == 1:
            return 0

        dp = [0] * n
        # 这一步不要忘记了
        dp[0] = 1
        # 再写后面几行
        for row in range(m):
            for col in range(n):
                # 【就分下面这两种情况就可以了】
                if obstacleGrid[row][col] == 1:
                    dp[col] = 0
                elif col > 0:
                    dp[col] += dp[col - 1]
                else:
                    # 第 0 列不是 0 就是 1
                    # 0 的情况首先判断了
                    # 什么都不做
                    pass
        return dp[-1]
