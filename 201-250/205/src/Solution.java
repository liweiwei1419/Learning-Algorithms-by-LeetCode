import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode-cn.com/problems/isomorphic-strings/description/
// 越是简单的问题，越有小陷阱
// 测试用例：输入：
//"ab"
//"aa"
//输出：
//false
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
                if (curT != map.get(curS)) {
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
        // write your code here
        // String s = "egg";String t = "add";
        // String s = "foo";String t = "bar";
        // String s = "paper";String t = "title";
        String s = "ab";
        String t = "aa";
        boolean isomorphic = new Solution().isIsomorphic(s, t);
        System.out.println(isomorphic);
    }
}
