import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // 因为题目中说，只有 26 个英文小写字母
        int[] chars = new int[26];
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return res;
        }
        for (char c : p.toCharArray()) {
            chars[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        int distance = p.length();
        while (right < s.length()) {
            if (chars[s.charAt(right) - 'a'] > 0) {
                distance--;
            }
            chars[s.charAt(right) - 'a']--;
            right++;
            if (distance == 0) {
                res.add(left);
            }

            if (right - left == p.length()) {
                if (chars[s.charAt(left) - 'a'] >= 0) {
                    distance++;
                }
                chars[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return res;
    }
}
