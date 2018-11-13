package leetcode.q198;

/**
 * 使用动态规划解决
 * Created by liwei on 17/10/3.
 */
public class Solution3 {

    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] memory = new int[len];
        for (int i = 0; i < len; i++) {
            memory[i] = -1;
        }
        for (int i = len - 1; i >= 0; i--) {
            int max = -1;
            for (int j = i; j < len; j++) {
                max = Integer.max(max, nums[j] + (j + 2 >= len ? 0 : memory[j + 2]));
            }
            memory[i] = max;
        }
        return memory[0];
    }

}
