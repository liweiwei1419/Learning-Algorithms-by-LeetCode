import java.util.Arrays;

public class Solution {

    // 三次扫描法

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        int[] leftMax = new int[len];
        int[] rightMax = new int[len];

        leftMax[0] = height[0];
        // 从当前位置向左边看最高的高度
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[len - 1] = height[len - 1];
        // 从当前位置向左边看最高的高度
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // System.out.println(Arrays.toString(leftMax));
        // System.out.println(Arrays.toString(rightMax));

        int res = 0;
        for (int i = 1; i < len - 1; i++) {
            res += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{2, 0, 2};
        Solution solution = new Solution();
        int res = solution.trap(height);
        System.out.println(res);
    }
}
