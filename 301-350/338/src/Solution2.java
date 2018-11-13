/**
 * 338. Bit位计数
 * https://leetcode-cn.com/problems/counting-bits/description/
 */
public class Solution2 {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & (i - 1)) == 0) {
                dp[i] = 1;
                continue;
            }
            // 000111010
            //
            dp[i] = dp[i - 1] + 1;
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(6));
    }
}
