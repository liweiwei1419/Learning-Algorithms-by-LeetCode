import java.util.Arrays;

// 练习（2刷）
public class Solution3 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = 1; i - j * j >= 0; j++) {
                res = Integer.min(1 + dp[i - j * j], res);
            }
            dp[i] = res;
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        // write your code here
        Solution3 solution = new Solution3();
        int numSquares = solution.numSquares(200);
        System.out.println(numSquares);
    }
}
