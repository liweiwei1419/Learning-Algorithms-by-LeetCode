import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int res = 1;
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0;
        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            // 这里等于号不要忘记了，因为要计算此时不重复子串的长度
            if (map.containsKey(c) && map.get(c) >= begin) {
                res = Integer.max(res, i - begin);
                // 重点理解这里 + 1 的含义
                begin = map.get(c) + 1;
            }
            map.put(c, i);
        }
        // 从 begin 到最后，很可能是不重复的子串，所以还要计算一次
        return Integer.max(res, len - begin);
    }

    public static void main(String[] args) {
        String s = "au";
        // String s = "abcabcbb";
        // String s = "bbbbb";
        // String s = "pwwkew";
        Solution solution = new Solution();
        int lengthOfLongestSubstring = solution.lengthOfLongestSubstring(s);
        System.out.println(lengthOfLongestSubstring);
    }
}
