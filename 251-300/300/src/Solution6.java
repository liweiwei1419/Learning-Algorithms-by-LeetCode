import java.util.Arrays;

/**
 * 作为练习，同 Solution
 * @author liwei
 * @date 18/6/30 下午4:18
 */
public class Solution6 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        // 自己一定是一个子序列
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            // 看以前的，比它小的，说明可以接在后面形成一个更长的子序列
            // int curMax = Integer.MIN_VALUE; 不能这样写，万一前面没有比自己小的，
            // 这个值就得不到更新
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int res = dp[0];
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution6 solution6 = new Solution6();
        int lengthOfLIS = solution6.lengthOfLIS(nums);
        System.out.println(lengthOfLIS);
    }
}
