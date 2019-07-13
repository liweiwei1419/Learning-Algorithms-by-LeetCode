import java.util.Arrays;

// 第 300 题
// https://leetcode.com/problems/longest-increasing-subsequence/description/
public class Solution7 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // 状态的定义是：以 i 结尾的最长上升子序列的长度
        // 状态转移方程：之前比最后那个数字小的最长上升子序列的长度 + 1
        int[] dp = new int[len];
        Arrays.fill(dp, 1); // 至少都是自己这个元素，默认值设置为 1 是合理的
        for (int i = 1; i < len; i++) {
            int curVal = nums[i];
            // 把之前的都找过去，找到最大的 + 1
            for (int j = 0; j < i; j++) {
                if (nums[j] < curVal) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < len; i++) {
            res = Integer.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution7 solution7 = new Solution7();
        int lengthOfLIS = solution7.lengthOfLIS(nums);
        System.out.println(lengthOfLIS);
    }
}