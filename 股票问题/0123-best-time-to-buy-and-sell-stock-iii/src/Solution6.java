/**
 * @author liweiwei1419
 * @date 2019/10/24 11:29 上午
 */
public class Solution6 {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // dp[i][j] ，i 表示 [0, i] 区间里，状态为 j 的最大收益
        // j = 0：什么都不操作
        // j = 1：第 1 次买入一支股票
        // j = 2：第 1 次卖出一支股票
        // j = 3：第 2 次买入一支股票
        // j = 4：第 2 次卖出一支股票

        int[][] dp = new int[len][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 比较奇怪的赋初值方法
        for (int i = 0; i < len; i++) {
            dp[i][2] = Integer.MIN_VALUE;
            dp[i][3] = Integer.MIN_VALUE;
            dp[i][4] = Integer.MIN_VALUE;
        }

        for (int i = 1; i < len; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);

            if (dp[i - 1][2] != Integer.MIN_VALUE) {
                dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            }

            if (dp[i - 1][3] != Integer.MIN_VALUE) {
                dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
            }
        }
        return Math.max(0, Math.max(dp[len - 1][2], dp[len - 1][4]));
    }

    public static void main(String[] args) {
        Solution6 solution6 = new Solution6();
        int[] prices = {1, 2, 3, 4, 5};
        int res = solution6.maxProfit(prices);
        System.out.println(res);
    }
}
