public class Solution {

    // 参考资料：滑动窗口模板，谷歌搜索关键字：滑动窗口 模板
    // 归纳步骤
    // https://zhuanlan.zhihu.com/p/69818691
    // https://blog.csdn.net/binling/article/details/45747193

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }
        int left = 0;
        int right = 0;
        // 至少是 1 个
        int res = 1;

        int[] window = new int[128];
        while (right < len) {
            Character curChar = s.charAt(right);
            window[curChar]++;
            while (window[s.charAt(right)] == 2) {
                Character leftChar = s.charAt(left);
                window[leftChar]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "bbbbb";
        Solution solution = new Solution();
        int res = solution.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
