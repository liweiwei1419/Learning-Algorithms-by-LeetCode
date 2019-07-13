public class Solution {

    /**
     * 常规 0-1 背包问题的写法
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return false;
        }

        int s = 0;
        for (int num : nums) {
            s += num;
        }

        // 特判 2：如果是奇数，就不符合要求
        if ((s & 1) == 1) {
            return false;
        }

        int target = s / 2;

        // 创建二维状态数组，行：物品索引，列：容量
        boolean[][] dp = new boolean[size][target + 1];
        // 先写第 1 行
        for (int i = 1; i < target + 1; i++) {
            if (nums[0] == i) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < target + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[size - 1][target];
    }
}
