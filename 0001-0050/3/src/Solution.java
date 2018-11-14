import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();

        // 0 和 1 是极端条件，可以先做判断
        if (len < 2) {
            return len;
        }

        int maxLen = 1;
        Map<Character, Integer> map = new HashMap<>();

        // 一个标记的点
        int pointer = 0;
        for (int i = 0; i < len; i++) {
            Character c = s.charAt(i);
            // 这里等于号不要忘记了，因为要计算此时不重复子串的长度
            if (map.containsKey(c) && map.get(c) >= pointer) {
                // 这里 point 在更新之前，所以不用 + 1
                maxLen = Integer.max(maxLen, i - pointer);
                // 重点理解这里 + 1 的含义
                pointer = map.get(c) + 1;
            }
            map.put(c, i);
        }
        // 从 pointer 到最后，很可能是不重复的子串，所以还要计算一次
        // 最后这一步不要忘记了
        return Integer.max(maxLen, len - pointer);
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
