public class Solution {

    public boolean validPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return true;
        }

        int l = 0;
        int r = len - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return validPalindrome(s, l + 1, r) || validPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }


    private boolean validPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
