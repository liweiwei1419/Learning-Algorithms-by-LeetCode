/**
 * 动态规划
 *
 * @author liwei
 */
public class Solution2 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len];
        // abcdedcba
        //   j   i
        // 如果 dp[j,i] = true 那么 dp[j + 1,i - 1] 也一定为 true
        // [j+1,i-1] 一定要构成至少两个元素额区间（ 1 个元素的区间，s.charAt(i)==s.charAt(j) 已经判断过了）
        // 即 j+1 > i-1，即 j > i - 2 (取到等号的情况可以放在 dp[j + 1][i - 1] 里判断，肯定为 True，因为单个字符一定是回文串)
        // 应该反过来写
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                // 区间应该慢慢放大
                if (s.charAt(i) == s.charAt(j) && (j > i - 2 || dp[j + 1][i - 1])) {
                    // 写成 dp[j][i] 就大错特错了，不要顺手写习惯了
                    dp[j][i] = true;
                    if (i - j + 1 > longestPalindrome) {
                        longestPalindrome = i - j + 1;
                        longestPalindromeStr = s.substring(j, i + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String longestPalindrome = solution2.longestPalindrome("aaaa");
        System.out.println(longestPalindrome);
    }
}
