/**
 * @author liweiwei1419
 * @date 2019/10/15 11:13 上午
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int len = coins.length;
        if (len == 0) {
            return -1;
        }

        // 要把 0 算进去，这是基本情况，所以开辟 coins 这么多空间的
        // 组成当前的总价值需要的最少硬币数
        int[] dp = new int[amount + 1];
        // dp 问题的套路，把初值先算出来，因为递归到底的时候，可能到这个地方
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    minCount = Integer.min(dp[i - coins[j]] + 1, minCount);
                }
            }
            dp[i] = minCount == Integer.MAX_VALUE ? -1 : minCount;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1};
        int amount = 0;
        int coinChange = solution.coinChange(coins, amount);
        System.out.println(coinChange);
    }
}
