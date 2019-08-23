/**
 * 暴力解法
 *
 * @author liwei
 * @date 2019/7/18 9:18 PM
 */
public class Solution5 {

    /**
     * 判断一个字符串是否是回文串
     * @param s
     * @return
     */
    private boolean isPalindromic(String s) {
        int len = s.length();
        int times = len/2;
        // 如果 len 是偶数的话，中间的那个字符可以不用看
        for (int i = 0; i < times; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    public String longestPalindrome(String s) {
        String ans = "";
        int maxLen = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            // j 是右边界，因为取不到，所以上界是 len
            for (int j = i + 1; j <= len; j++) {
                String sub = s.substring(i, j);
                if (isPalindromic(sub) && sub.length() > maxLen) {
                    ans = s.substring(i, j);
                    maxLen = Math.max(maxLen, ans.length());
                }
            }

        }
        return ans;
    }
}
