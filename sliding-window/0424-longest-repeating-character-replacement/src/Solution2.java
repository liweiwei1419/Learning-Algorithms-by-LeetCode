/**
 * @author liweiwei1419
 * @date 2019/10/11 7:27 下午
 */
public class Solution2 {

    public int characterReplacement(String s, int k) {
        int sLen = s.length();
        if (sLen < 2) {
            return sLen;
        }

        int left = 0;
        int right = 0;
        int[] cnt = new int[128];
        // 重复字符最多的元素
        int maxCount = 0;
        int res = 1;
        while (right < sLen) {
            cnt[s.charAt(right)]++;
            maxCount = Math.max(maxCount, cnt[s.charAt(right)]);
            right++;

            while (right - left > maxCount + k) {
                cnt[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
