public class Solution3 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int res = 0;
        int preMin = prices[0];
        for (int i = 1; i < len; i++) {
            preMin = Math.min(preMin, prices[i]);
            res = Math.max(res, prices[i] - preMin);
        }
        return res;
    }
}
