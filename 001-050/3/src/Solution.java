import java.util.HashMap;
import java.util.Map;

public class Solution {


    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int start = 0;
        int res = 1;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                if(map.get(chars[i]) >= start){
                    // 更新 start
                    start = map.get(chars[i]) + 1;
                }
            }
            res = Integer.max(res, i - start + 1);
            map.put(chars[i], i);
        }
        return res;
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
