public class Solution4 {

    // 刘宇波老师给出的思路，使用滑动窗口的思路
    // 不是很好理解，供参考

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        // 特判
        if (len < 2) {
            return len;
        }
        int[] counter = new int[128];
        int res = 1;

        int left = 0;
        // 滑动窗口的逻辑是尝试向右移动一位，因此，初始值是 -1
        int right = -1;

        // 认为左边界更重要，有重复的子串，我们记录左边，舍弃右边，因此左边界如果越界了，算法停止
        while (left < len) {
            // right + 1 表示最多到 len - 1
            // counter[s.charAt(right + 1)] == 0 表示在 [left, right] 这个区间里没有出现
            if (right + 1 < len && counter[s.charAt(right + 1)] == 0) {
                // 右边第 1 个字母加入频率数组，频数 + 1
                counter[s.charAt(right + 1)]++;
                right++;
            } else {
                // 如果下一个字符已经越界了，或者右边第 1 个字母是频率数组是曾经出现过的
                // 把左边从频数数组中挪掉，频数减 1
                counter[s.charAt(left)]--;
                left++;
            }
            // 经过上面的分支，窗口 [left, right] 内一定没有重复元素，故记录最大值
            res = Math.max(res, right - left + 1);
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
