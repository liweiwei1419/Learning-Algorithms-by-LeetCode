// 动态规划的解法
public class Solution2 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = max3(j * dp[i - j], max, j * (i - j));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    private int max3(int a, int b, int c) {
        return Integer.max(Integer.max(a, b), c);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int maxBreak = s.integerBreak(10);
        System.out.println(maxBreak);
        for (int i = 1; i < 13; i++) {
            maxBreak = s.integerBreak(i);
            System.out.println(maxBreak);
        }
    }
}
