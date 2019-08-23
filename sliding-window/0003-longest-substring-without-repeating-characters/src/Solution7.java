/**
 * @author liwei
 * @date 2019/8/23 10:53 AM
 */
public class Solution7 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }

        int[] window = new int[128];
        int res = 1;

        int left = 0;
        int right = 0;
        while (right < len) {
            Character curChar = s.charAt(right);
            window[curChar]++;
            right++;
            while (window[curChar] == 2) {
                // 左边界向右边走
                Character leftChar = s.charAt(left);
                window[leftChar]--;
                left++;
            }
            // 注意：应该放在这里，并且注意边界
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution7 solution7 = new Solution7();
        int res = solution7.lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
