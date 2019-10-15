public class Solution2 {

    // 动态规划，从后面向前面

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] dp = new int[len];
        dp[len - 1] = nums[len - 1];

        // 从后向前写
        for (int i = len - 1; i >= 0; i--) {
            int res = -1;
            for (int j = i; j < len; j++) {
                res = Math.max(res, nums[j] + (j + 2 >= len ? 0 : dp[j + 2]));
            }
            dp[i] = res;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        // int[] nums = {0};
        // int[] nums = {1, 2, 3, 1};
        // int[] nums = {1, 3, 1};
        int[] nums = {2,1, 1, 2};

        // int[] nums = {1, 2, 3, 1};
        // int[] nums = {2, 7, 9, 3, 1};
        //int[] nums = {1,2};
        Solution2 solution = new Solution2();
        int rob = solution.rob(nums);
        System.out.println(rob);
    }
}
