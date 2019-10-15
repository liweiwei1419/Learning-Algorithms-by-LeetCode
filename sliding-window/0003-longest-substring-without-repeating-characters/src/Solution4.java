import java.util.HashMap;
import java.util.Map;

public class Solution4 {
// 动态规划

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }

        // dp[i] 表示以 s[i] 结尾的最长不重复子串的长度
        // 因为自己肯定是不重复子串，所以初始值设置为 1
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        // 因为要考虑 dp[i - 1]，索引得从 1 开始，故 d[s[0]] = 0 得先写上
        for (int i = 1; i < len; i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                if (dp[i - 1] >= i - map.get(c)) {
                    dp[i] = i - map.get(c);
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = dp[i - 1] + 1;

            }
            // 设置字符与索引键值对
            map.put(c, i);
        }
        // 最后拉通看一遍最大值
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}