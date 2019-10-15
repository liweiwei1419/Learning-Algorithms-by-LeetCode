/**
 * @author liweiwei1419
 * @date 2019/10/10 6:40 下午
 */
public class Solution5 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int[] counter = new int[128];
        boolean repeating = false;
        int left = 0;
        int right = 0;
        int res = 1;
        while (right < len) {
            if (counter[s.charAt(right)] == 1) {
                repeating = true;
            }
            counter[s.charAt(right)]++;
            right++;
            while (repeating) {
                if (counter[s.charAt(left)] == 2) {
                    repeating = false;
                }
                counter[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
