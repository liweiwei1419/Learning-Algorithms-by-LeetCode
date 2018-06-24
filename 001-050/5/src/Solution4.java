/**
 * 动态规划解法：作为练习
 *
 * @author liwei
 * @date 18/6/20 上午10:02
 */
public class Solution4 {

    public String longestPalindrome(String s) {
        // 首先处理极端情况
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.charAt(0) + "";
        // dp[j][i] 表示 s[j][i] 是否是回文串
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    // 此时长度为 1 ，不用记录
                    dp[j][i] = true;
                    break;
                }
                // 小心越界问题，即 j + 1 < i - 1，即 j < i-2
                if (s.charAt(j) == s.charAt(i) && (j >= i - 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    // 此时，区间长度为 i-j+1
                    if (i - j + 1 > longestPalindrome) {
                        longestPalindrome = i - j + 1;
                        longestPalindromeStr = s.substring(j, i + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }
}
