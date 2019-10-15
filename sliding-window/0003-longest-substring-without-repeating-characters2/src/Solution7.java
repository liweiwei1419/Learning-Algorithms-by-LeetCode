/**
 * @author liweiwei1419
 * @date 2019/10/12 2:16 下午
 */
public class Solution7 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        // 当 window 中某个字符的频数为 2 时，表示滑动窗口内有重复字符
        int[] window = new int[128];

        // 右边界滑动到刚刚好有重复的时候停下
        // 左边界滑动到刚刚好没有重复的时候停下
        int left = 0;
        int right = 0;
        int res = 1;
        boolean repeating = false;
        while (right < len) {
            window[s.charAt(right)]++;
            if (window[s.charAt(right)] == 2) {
                repeating = true;
            }
            right++;

            while (repeating) {
                window[s.charAt(left)]--;
                if (window[s.charAt(left)] == 1) {
                    repeating = false;
                }
                left++;
            }
            // 此时 [left, right) 无重复元素
            res = Math.max(res, right - left);

        }
        return res;
    }
}
