/**
 * @author liweiwei1419
 * @date 2019/10/11 8:13 下午
 */
public class Solution2 {


    public boolean checkInclusion(String s1, String s2) {
        int s2Len = s2.length();
        int s1Len = s1.length();
        if (s2Len == 0) {
            return false;
        }
        int[] pattern = new int[128];
        int[] window = new int[128];
        for (char s1Char : s1.toCharArray()) {
            pattern[s1Char]++;
        }
        int s1Count = 0;
        int s2Count = 0;
        for (int i = 0; i < 128; i++) {
            if (pattern[i] > 0) {
                s1Count++;
            }
        }
        int left = 0;
        int right = 0;
        while (right < s2Len) {
            if(pattern[s2.charAt(right)] > 0){
                window[s2.charAt(right)]++;
                if(window[s2.charAt(right)] == pattern[s2.charAt(right)]){
                    s2Count++;
                }
            }
            right++;
            while (s1Count == s2Count){
                if(right - left == s1Len){
                    return true;
                }
                if(pattern[s2.charAt(left)] > 0){
                    window[s2.charAt(left)]--;
                    if(window[s2.charAt(left)] < pattern[s2.charAt(left)]){
                        s2Count--;
                    }
                }
                left++;
            }

        }
        return false;
    }
}
