// https://leetcode-cn.com/problems/unique-paths/description/
// 更省空间的写法
public class Solution3 {

    // i,j 的值来源：上面和前面的值之和
    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        // 输入: m = 7, n = 3
        // 输出: 28
        Solution3 solution = new Solution3();
        int m = 7;
        int n = 3;
        int uniquePaths = solution.uniquePaths(m, n);
        System.out.println(uniquePaths);
    }
}
