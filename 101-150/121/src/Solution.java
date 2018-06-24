public class Solution {

    // 在遍历的时候，记录之前的最小值
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int maxProfit = 0;
        // 之前遍历到的所有元素的最小值
        int preMinium = prices[0];
        for (int i = 1; i < len; i++) {
            maxProfit = Integer.max(maxProfit, prices[i] - preMinium);
            preMinium = Integer.min(preMinium, prices[i]);
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