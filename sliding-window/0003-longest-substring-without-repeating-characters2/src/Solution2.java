/**
 * @author liweiwei1419
 * @date 2019/10/9 12:32 下午
 */
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }
        int left = 0;
        int right = 0;
        int[] counter = new int[128];
        boolean repeating = false;
        int res = 1;
        while (right < len) {
            if (counter[s.charAt(right)] == 1) {
                // 说明有重复了
                repeating = true;
            }
            // 下面这两行的顺序不能对换
            counter[s.charAt(right)]++;
            right++;
            while (repeating) {
                // 如果满足滑动窗口内有重复的元素，尝试不断删除左边元素
                if (counter[s.charAt(left)] == 2) {
                    // 说明删除掉这个字符以后，滑动窗口无重复
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
