/**
 * @author liweiwei1419
 * @date 2019/9/22 10:56 下午
 */
public class Solution3 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            return firstMatch && isMatch(s.substring(1), p);
        }
        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
}
