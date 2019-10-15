import java.util.Arrays;

public class Solution {

    // 暴力解法：中心扩散，找到两边最高的那个高度，还要减去自己的高度

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int leftMax = leftMax(i, height);
            int rightMax = rightMax(i, height, len);

            // 核心逻辑
            if (height[i] < Math.min(leftMax, rightMax)) {
                res += Math.min(leftMax, rightMax) - height[i];
            }
        }
        return res;
    }

    private int leftMax(int center, int[] height) {
        int res = 0;
        for (int i = center - 1; i >= 0; i--) {
            res = Math.max(res, height[i]);
        }
        return res;
    }

    private int rightMax(int center, int[] height, int n) {
        // 看看向右最多能走多远
        int res = 0;
        for (int i = center + 1; i < n; i++) {
            res = Math.max(res, height[i]);
        }
        return res;
    }
}
