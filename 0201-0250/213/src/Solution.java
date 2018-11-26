// https://leetcode-cn.com/problems/house-robber-ii/description/

public class Solution {

    // 根据 0-1 背包问题的策略，一个房间，其实就只有偷和不偷的差别
    // 状态：f(i) 表示从 [0,...,i] 这么多房间，按照规则偷取的价值总和
    // 状态转移方程：f(i) = max(v(i) + f(i-2),f(i-1))
    private int tryRob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Integer.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }


    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] nums1 = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            nums1[i] = nums[i];
        }
        int[] nums2 = new int[len - 1];
        for (int i = 1; i < len; i++) {
            nums2[i - 1] = nums[i];
        }
        return Integer.max(tryRob(nums1), tryRob(nums2));
    }


    public static void main(String[] args) {
        // write your code here

        // 输入: [2,3,2]
        // 输出: 3

        //输入: [1,2,3,1]
        //输出: 4

        // int[] nums = {2,3,2};
        // int[] nums = {1,2,3,1};
        // int[] nums = {100};
        int[] nums = {0, 0};
        Solution solution = new Solution();
        int rob = solution.rob(nums);
        System.out.println(rob);
    }
}
