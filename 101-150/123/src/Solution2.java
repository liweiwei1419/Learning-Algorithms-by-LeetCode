/**
 * @author liwei
 */
public class Solution2 {

    public int maxProfit(int[] prices) {
        // 不论是买和买，都先假设一个最坏的情况
        // 买的时候，最坏我只买不卖，钱会越来越少
        int buy1 = Integer.MIN_VALUE;
        // 卖的时候，因为求最大值，我最差什么情况就是不交易，收益为 0
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        for (int price : prices) {
            buy1 = Integer.max(buy1, -price);
            sell1 = Integer.max(sell1, price + buy1);
            buy2 = Integer.max(buy2, sell1 - price);
            sell2 = Integer.max(sell2, price + buy2);
        }
        return sell2;
    }

    public static void main(String[] args) {
        // int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices = {1, 2, 3, 4, 5};
        Solution2 solution2 = new Solution2();
        int maxProfit = solution2.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
