/**
 * @author liweiwei1419
 * @date 2019/10/22 7:47 上午
 */
public class Solution4 {

    // TODO: 2019/10/22 这个解法是错的，待修正 

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // i 到第几天
        // j 第几次交易
        // k 是否持有股票

        int[][][] dp = new int[len][3][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];
        dp[0][1][0] = -1;
        dp[0][1][1] = -1;
        dp[0][2][0] = -1;
        dp[0][2][1] = -1;

        int res = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i]);

            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);


            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][1][1] + prices[i]);


            res = max3(dp[i][0][0], dp[i][1][0], dp[i][2][0]);
        }
        return res;
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }


    public static void main(String[] args) {
        // int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        // int[] prices = {1, 2, 3, 4, 5};
        int[] prices = {7, 6, 4, 3, 1};
        Solution4 solution4 = new Solution4();
        int res = solution4.maxProfit(prices);
        System.out.println(res);
    }
}
