public class Solution2 {

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        int[] leftMax = new int[len];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        int[] rightMax = new int[len];
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            // 核心逻辑
            if (height[i] < minHeight) {
                res += minHeight - height[i];
            }
        }
        return res;
    }


}
