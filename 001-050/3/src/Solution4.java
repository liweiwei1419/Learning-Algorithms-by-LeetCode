public class Solution4 {

    // 定义成频率数组，刘宇波老师给出的思路，使用滑动窗口的思路

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return len;
        }
        int[] freq = new int[128];
        int res = 1;

        int l = 0;
        int r = -1;

        while (l < len) {
            if (r + 1 < len && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            } else {
                freq[s.charAt(l++)]--;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        String s = "abcabcbb";
        int lengthOfLongestSubstring = solution4.lengthOfLongestSubstring(s);
        System.out.println(lengthOfLongestSubstring);
    }
}
