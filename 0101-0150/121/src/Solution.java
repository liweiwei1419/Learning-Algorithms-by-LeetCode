
// 从零开始学贪心算法 - CSDN博客  https://blog.csdn.net/qq_32400847/article/details/51336300

public class Solution {
    /**
     * 在遍历的时候，记录之前遍历到的元素的最小值
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int maxProfit = 0;
        // 之前遍历到的所有元素的最小值
        int preMinimum = prices[0];
        // 从索引为 1 的元素开始
        for (int i = 1; i < len; i++) {
            // 当前值减去之前遍历到的元素的最小值，从中取出最大，即为所求
            maxProfit = Integer.max(maxProfit, prices[i] - preMinimum);
            preMinimum = Integer.min(preMinimum, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }


}