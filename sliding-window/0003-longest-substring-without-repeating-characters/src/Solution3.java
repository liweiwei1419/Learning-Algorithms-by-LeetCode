import java.util.Arrays;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }

        int[] chars = new int[128];

        // 滑动窗口的开始
        int left = 0;
        int res = 1;
        for (int right = 0; right < len; right++) {
            Character c = s.charAt(right);
            // 下面这一行是调试的代码
            // System.out.println("当前字符：" + c + "，出现的索引：" + chars[c]);
            if (chars[c] != 0 && chars[c] >= left) {
                // 此时就要做更新了
                res = Math.max(res, right - left);
                left = chars[c] + 1;
            }
            // 不论怎么样都要更新
            chars[c] = right;
        }
        // 最后还需要再判断一下
        return Math.max(res, len - left);
    }

}
