import java.util.Arrays;

/**
 * @author liwei
 * @date 18/6/22 下午3:20
 */
public class Solution {
    public int firstUniqChar(String s) {
        int len = s.length();
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return 0;
        }
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[i] = 0;
        }
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            map[index]++;
        }
        for (int i = 0; i < len; i++) {
            int index = s.charAt(i) - 'a';
            if (map[index] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "leetcode";
        Solution solution = new Solution();
        int firstUniqChar = solution.firstUniqChar(str);
        System.out.println(firstUniqChar);
    }
}