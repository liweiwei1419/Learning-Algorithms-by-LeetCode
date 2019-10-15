import java.util.Arrays;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }
        int[] hash = new int[128];
        for (int i = 0; i < 128; i++) {
            hash[i] = -1;
        }
        // 滑动窗口的开始
        int left = 0;
        int right = 0;
        int res = 1;
        while (right < len) {
            Character c = s.charAt(right);
            // 下面这一行是调试的代码
            // System.out.println("当前字符：" + c + "，出现的索引：" + hash[c]);
            if (hash[c] != -1 && hash[c] >= left) {
                // 此时就要做更新了
                left = hash[c] + 1;
            }
            // 不论怎么样都要更新
            res = Math.max(res, right - left + 1);
            hash[c] = right;
            right++;
        }
        // 最后还需要再判断一下
        return res;
    }

    public static void main(String[] args) {
        String s = "au";
        Solution3 solution3 = new Solution3();
        int res = solution3.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
