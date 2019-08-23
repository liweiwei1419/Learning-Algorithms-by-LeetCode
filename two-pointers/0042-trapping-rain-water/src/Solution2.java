public class Solution2 {

    // 针对三次扫描的优化：双指针

    public int trap(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        int leftMax = height[0];
        int rightMax = height[len - 1];

        int left = 0;
        int right = len - 1;

        int res = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                res += (leftMax - height[left]);
                left++;
            } else {
                res += (rightMax - height[right]);
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{3, 0, 0, 1, 0, 2, 0, 4};
        Solution2 solution2 = new Solution2();
        int res = solution2.trap(height);
        System.out.println(res);
    }
}
