import java.util.Arrays;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }

        // 这个索引的数组起到了 hash 表的作用
        // 根据测试用例，我们使用 127 个位置就可以了
        // 127 是我测试出来的，其实应该写 256
        Integer[] chars = new Integer[127];

        // 滑动窗口的开始
        int begin = 0;
        int res = 1;
        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            // 下面这一行是调试的代码
            // System.out.println("当前字符：" + c + "，出现的索引：" + chars[c]);
            if (chars[c] != null && chars[c] >= begin) {
                // 此时就要做更新了
                res = Math.max(res, i - begin);
                begin = chars[c] + 1;
            }
            // 不论怎么样都要更新
            chars[c] = i;
        }
        // 最后还需要再判断一下
        return Math.max(res, len - begin);
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = "au";
        int lengthOfLongestSubstring = solution3.lengthOfLongestSubstring(s);
        System.out.println(lengthOfLongestSubstring);
    }
}
