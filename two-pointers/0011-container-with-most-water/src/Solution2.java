/**
 * @author liwei
 * @date 18/7/2 下午9:16
 */
public class Solution2 {

    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) {
            return 0;
        }

        int left = 0;
        int right = len - 1;
        int res = -1;
        while (left < right) {
            int curVal = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, curVal);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
