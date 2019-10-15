/**
 * @author liweiwei1419
 * @date 2019/10/7 7:49 下午
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int[] window = new int[128];
        int left = 0;
        int right = 0;
        // 滑动窗口内是否重复
        boolean repeating = false;
        int res = 1;
        // 循环不变式：[left, right) 内没有重复元素
        while (right < len) {
            // 不能写在后面，因为数组下标容易越界
            if (window[s.charAt(right)] == 1) {
                repeating = true;
            }
            window[s.charAt(right)]++;
            right++;

            // 此时 [left, right) 内如果没有重复元素，就尝试扩张 right
            // 否则缩小左边界，while 循环体内不断缩小边界
            while (repeating) {
                if (window[s.charAt(left)] == 2) {
                    repeating = false;
                }
                // 只有有重复元素，就得缩短左边界
                window[s.charAt(left)]--;
                left++;
            }
            // 此时 [left, right) 内没有重复元素
            res = Math.max(res, right - left);
        }
        return res;
    }
}
