public class Solution2 {

    // 留意这个解法的语义

    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int price : prices) {
            // 在当前以及之前如果执行了买操作，能够得到的利润的最大值
            buy = Math.max(buy, -price);
            // 在当前以及之前如果执行了卖操作，能够得到的利润的最大值
            sell = Math.max(sell, buy + price);
        }
        return sell;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Solution2 solution2 = new Solution2();
        int maxProfit = solution2.maxProfit(prices);
        System.out.println(maxProfit);
    }
}