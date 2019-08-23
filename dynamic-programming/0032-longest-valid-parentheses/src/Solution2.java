/**
 * @author liwei
 * @date 2019/8/16 12:44 PM
 */
public class Solution2 {

    // 动态规划

    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int maxLen = 0;
        int[] dp = new int[len];
        // 从后向前递推
        for (int i = len - 2; i >= 0; i--) {
            int symIndex = (i + 1) + dp[i + 1];
            if ('(' == s.charAt(i) && symIndex < len
                    && ')' == s.charAt(symIndex)) {
                dp[i] = dp[i + 1] + 2;
                if (symIndex + 1 < len) {
                    dp[i] += dp[symIndex + 1];
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        String s = ")()())";
        Solution2 solution2 = new Solution2();
        int longestValidParentheses = solution2.longestValidParentheses(s);
        System.out.println(longestValidParentheses);
    }

}
