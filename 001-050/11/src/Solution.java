public class Solution {

    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) {
            return 0;
        }
        int l = 0;
        int r = len - 1;
        int res = 0;
        while (l < r) {
            int area = (r - l) * Integer.min(height[l], height[r]);
            res = Integer.max(res, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                // height[l] >= height[r]
                r--;
            }
        }
        return res;
    }


    // 暴力解法，时间复杂度太高，我们应该使用指针对撞的方法
    public int maxArea1(int[] height) {
        int len = height.length;
        if (len < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                res = Integer.max(res, Integer.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }
}
