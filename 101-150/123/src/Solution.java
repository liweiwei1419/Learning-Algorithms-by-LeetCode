/**
 * 思路1：处理成 LeetCode 第 121 题
 * 要特别注意的就是边界情况了
 *
 * @author liwei
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            maxProfit = Integer.max(maxProfit(prices, 0, i) + maxProfit(prices, i + 1, len - 1), maxProfit);
        }
        return maxProfit;
    }

    private int maxProfit(int[] prices, int l, int r) {
        int len = prices.length;
        if (len == 0 || l < 0 || l >= len) {
            return 0;
        }
        int preMinimum = prices[l];
        int maxProfit = 0;
        for (int i = l + 1; i <= r; i++) {
            maxProfit = Integer.max(prices[i] - preMinimum, maxProfit);
            preMinimum = Integer.min(preMinimum, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        // int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices = {1, 2, 3, 4, 5};
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
