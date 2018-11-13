/**
 * 521. 最长特殊序列 Ⅰ
 * https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/description/
 *
 * @author liwei
 */
public class Solution {

    public int findLUSlength(String a, String b) {
        if (a != null && a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
