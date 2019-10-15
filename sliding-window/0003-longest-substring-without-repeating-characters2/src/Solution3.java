/**
 * @author liweiwei1419
 * @date 2019/10/9 1:38 下午
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int left = 0;
        int right = 0;
        int[] counter = new int[128];
        boolean repeating  = false;
        int res = 1;
        while (right < len){
            counter[s.charAt(right)]++;
            if (counter[s.charAt(right)] == 2){
                repeating = true;
            }
            right++;
            // 此时 [left, right) 内没有重复元素
            while(repeating){
                // 尝试收缩左区间
                if(counter[s.charAt(left)] == 2){
                    repeating = false;
                }
                counter[s.charAt(left)]--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
