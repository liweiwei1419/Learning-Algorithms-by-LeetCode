/**
 * @author liweiwei1419
 * @date 2019/10/10 6:30 下午
 */
public class Solution4 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }
        int left = 0;
        int right = 0;
        int[] window = new int[128];
        boolean repeating = false;
        int res = 0;
        while (right < len) {
            if (window[s.charAt(right)] == 1) {
                repeating = true;
            }
            window[s.charAt(right)]++;
            right++;
            while (repeating) {
                if (window[s.charAt(left)] == 2) {
                    repeating = false;
                }
                window[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
