// 作为练习
public class Solution2 {

    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        boolean palindrome = solution2.isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);
    }
}
