public class Solution {

    public String longestCommonPrefix(String[] strs) {
        int arrLen = strs.length;
        if (arrLen == 0) {
            return "";
        }
        // 根据题意，最长不会超过字符串数组的第 1 个字符串的长度
        int maxLen = strs[0].length();
        for (int begin = 0; begin < maxLen; begin++) {
            // 从索引为 1 的字符串开始比较就行
            for (int i = 1; i < arrLen; i++) {
                if (begin == strs[i].length() || strs[0].charAt(begin) != strs[i].charAt(begin)) {
                    return strs[0].substring(0, begin);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = {"aa", "a"};
        Solution solution = new Solution();
        String longestCommonPrefix = solution.longestCommonPrefix(strs);
        System.out.println(longestCommonPrefix);
    }
}
