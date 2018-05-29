
// https://leetcode-cn.com/problems/palindrome-number/description/
// 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
public class Solution {

    // 12345
    // 5
    // 4
    // 3
    // 如果 x < 0 直接就可以判断不是回文数
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == reverse(x);
    }

    private int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 12321;
        boolean palindrome = solution.isPalindrome(x);
        System.out.println(palindrome);
    }
}
