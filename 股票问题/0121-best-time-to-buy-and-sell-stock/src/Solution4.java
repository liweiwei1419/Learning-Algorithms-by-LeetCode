public class Solution4 {
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
        int res = 0;
        // 之前遍历到的所有元素的最小值
        int preMinimum = prices[0];
        // 从索引为 1 的元素开始
        for (int i = 1; i < len; i++) {
            // 当前值减去之前遍历到的元素的最小值，从中取出最大，即为所求
            res = Math.max(res, prices[i] - preMinimum);
            preMinimum = Math.min(preMinimum, prices[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
