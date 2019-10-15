public class Solution2 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int climbStairs = solution.climbStairs(2);
        System.out.println(climbStairs);
    }
}
