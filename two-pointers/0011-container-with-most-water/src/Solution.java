/**
 * @author liwei
 * @date 2019/8/27 11:14 PM
 */
public class Solution {

    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) {
            return 0;
        }

        int left = 0;
        int right = len - 1;

        int res = 0;
        while (left < right) {
            int minH = Math.min(height[left], height[right]);
            res = Math.max(res, minH * (right - left));

            if (height[left] == minH) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution solution = new Solution();
        int res = solution.maxArea(height);
        System.out.println(res);
    }
}
