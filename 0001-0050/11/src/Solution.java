public class Solution {

    // 指针对撞、贪心思想
    // 参考解答：https://www.cnblogs.com/zichi/p/5745992.html

    public int maxArea(int[] height) {
        int len = height.length;
        if (len < 2) {
            // 0 或者 1 的时候，不能形成区间，所以不能形成容器
            return 0;
        }
        int l = 0;
        int r = len - 1;
        int res = 0;
        while (l < r) {
            // 这里其实就是木桶原理，取决于最短的那根木板
            // [1,2,3] 3 和 1 之间的长度就是 (3-1=)2
            int area = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(res, area);
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
