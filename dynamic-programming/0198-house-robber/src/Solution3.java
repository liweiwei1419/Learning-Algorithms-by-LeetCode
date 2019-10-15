public class Solution3 {

    // 动态规划：从前面向后面

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = -1;
        }

        // 从后向前写
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i] = Math.max(dp[i], nums[j] + (j + 2 >= len ? 0 : dp[j + 2]));
            }
        }
        return dp[0];
    }

}
