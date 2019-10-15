/**
 * @author liweiwei1419
 * @date 2019/10/11 7:03 下午
 */
public class Solution {

    // 参考资料：
    // 1、五分钟学算法：https://mp.weixin.qq.com/s/6YeZUCYj5ft-OGa85sQegw
    // 2、阿飞的有道云笔记：https://note.youdao.com/ynoteshare1/index.html?id=270d3cd80b048c1074dcfa5b14ece4b4&type=note
    // 3、labuladong：《滑动窗口通用思想解决子串问题》
    // https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/hua-dong-chuang-kou-tong-yong-si-xiang-jie-jue-zi-/

    public int characterReplacement(String s, int k) {
        int sLen = s.length();
        if (sLen == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        // 因为题目中说，只出现大写字母
        int[] cnt = new int[26];
        int maxCount = 0;
        int res = 1;
        while (right < sLen) {
            int rCharIndex = s.charAt(right) - 'A';
            cnt[rCharIndex]++;
            // 注意：在这里更新
            maxCount = Math.max(maxCount, cnt[rCharIndex]);
            right++;
            while (right - left > maxCount + k) {
                cnt[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;

    }
}
