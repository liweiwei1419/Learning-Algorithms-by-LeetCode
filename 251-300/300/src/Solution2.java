import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/description/
public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
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
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Integer.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution2 solution2 = new Solution2();
        int lengthOfLIS = solution2.lengthOfLIS(nums);
        System.out.println(lengthOfLIS);
    }
}