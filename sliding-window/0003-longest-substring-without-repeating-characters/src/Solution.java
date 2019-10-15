public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int res = 1;
        int[] hash = new int[128];
        while (right < len) {
            if (hash[s.charAt(right)] == 1) {
                count++;
            }
            hash[s.charAt(right)]++;
            right++;
            while (count > 0) {
                if (hash[s.charAt(left)] == 2) {
                    count--;
                }
                hash[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
