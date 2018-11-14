import java.util.HashMap;
import java.util.Map;

/**
 * @author liwei
 * @date 18/6/22 下午6:46
 */
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int pointer = 0;
        int maxLen = 1;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if (map.get(chars[i]) >= pointer) {
                    // 更新 pointer
                    pointer = map.get(chars[i]) + 1;
                }
            }
            maxLen = Integer.max(maxLen, i - pointer + 1);
            map.put(chars[i], i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        // String s = "abcabcbb";
        // String s = "bbbbb";
        // String s = "pwwkew";
        String s = "dvdf";
        Solution2 solution2 = new Solution2();
        int lengthOfLongestSubstring = solution2.lengthOfLongestSubstring(s);
        System.out.println(lengthOfLongestSubstring);
    }
}