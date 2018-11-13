import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode-cn.com/problems/isomorphic-strings/description/

// 重点：建立映射关系的时候，要检查是不是两个 key 对应到同一个 value 上了

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        if (n != t.length()) {
            return false;
        }
        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        Character curS;
        Character curT;
        for (int i = 0; i < n; i++) {
            curS = s.charAt(i);
            curT = t.charAt(i);
            if (map.containsKey(curS)) {
                if (!curT.equals(map.get(curS))) {
                    return false;
                }
            } else {
                if (set.contains(curT)) {
                    return false;
                } else {
                    set.add(curT);
                    map.put(curS, curT);
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        // String s = "egg";String t = "add";
        // String s = "foo";String t = "bar";
        // String s = "paper";String t = "title";
        String s = "ab";
        String t = "aa";
        boolean isomorphic = new Solution().isIsomorphic(s, t);
        System.out.println(isomorphic);
    }
}
