/**
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * @author liwei
 */
public class Solution {

    public boolean isPalindrome(String s) {
        int len = s.length();
        // 如果字符只有 1 个字母，那么也一定是回文数
        if (len < 2) {
            return true;
        }
        s = s.toLowerCase();
        // 只保留小写字母和数字
        s = s.replaceAll("[^0-9a-z]", "");
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            if (cl != cr) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean palindrome = solution.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);

        for (char i = '0'; i <= '9'; i++) {
            System.out.print((int) i + "\t");
        }
        System.out.println();
        for (char i = 'a'; i <= 'z'; i++) {
            System.out.print((int) i + "\t");
        }
        System.out.println();

        for (char i = 'A'; i <= 'Z'; i++) {
            System.out.print((int) i + "\t");
        }
    }
}
