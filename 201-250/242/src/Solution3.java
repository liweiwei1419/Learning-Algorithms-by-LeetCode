import java.util.HashMap;
import java.util.Map;

// 思路和 1 基本一致
public class Solution3 {
    public boolean isAnagram(String s, String t) {
        boolean isAnagram = true;
        if (s.length() != t.length()) {
            isAnagram = false;
        } else {
            char[] sArray = s.toCharArray();
            Map<Character, Integer> map1 = new HashMap<>();
            for (char c : sArray) {
                if (map1.containsKey(c)) {
                    map1.put(c, map1.get(c) + 1);
                } else {
                    map1.put(c, 1);
                }
            }

            char[] tArray = t.toCharArray();
            for (char c : tArray) {
                if (map1.containsKey(c) && map1.get(c) >= 1) {
                    map1.put(c, map1.get(c) - 1);
                } else {
                    isAnagram = false;
                    break;
                }
            }

        }
        return isAnagram;
    }
}


