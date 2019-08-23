/**
 * @author liwei
 * @date 2019/8/22 12:09 PM
 */
public class Solution3 {


    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // 状态定义：以索引 i 结尾
        int[][] dp = new int[len][2];

        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                dp[i][1] = Math.max(nums[i], dp[i - 1][1] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][0] * nums[i]);
            } else {
                dp[i][1] = Math.max(nums[i], dp[i - 1][0] * nums[i]);
                dp[i][0] = Math.min(nums[i], dp[i - 1][1] * nums[i]);
            }
        }

        int res = dp[0][1];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        Solution3 solution3 = new Solution3();
        int res = solution3.maxProduct(nums);
        System.out.println(res);
    }
}
