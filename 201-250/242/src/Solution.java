import java.util.HashMap;
import java.util.Map;

// 很简单的一个问题，基本上也是不用动脑子就能写出解答的
// https://leetcode-cn.com/problems/valid-anagram/description/
// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        for (Character c : t.toCharArray()) {
            if (map.containsKey(c) && map.get(c) >= 1) {
                map.put(c, map.get(c) - 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    // https://leetcode-cn.com/problems/valid-anagram/description/
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean anagram = new Solution().isAnagram(s, t);
        System.out.println(anagram);
    }
}
