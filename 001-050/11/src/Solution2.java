/**
 * @author liwei
 * @date 18/7/2 下午9:16
 */
public class Solution2 {

    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0;
        int r = len - 1;
        int res = -1;
        while (l < r) {
            int curVal = Math.min(height[l], height[r]) * (r - l);
            res = Math.max(res, curVal);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
