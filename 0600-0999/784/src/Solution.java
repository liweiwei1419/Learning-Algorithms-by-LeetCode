import java.util.ArrayList;
import java.util.List;

/**
 * 我自己写的
 */
public class Solution {

    private void helper(char[] chars, int len, int begin, List<String> res) {
        if (begin == len) {
            res.add(new String(chars));
            return;
        }
        // 不变化的时候递归搜索一次
        helper(chars, len, begin + 1, res);
        if ((chars[begin] + "").matches("[a-zA-Z]")) {
            change(chars, begin);
            // 变化了以后递归搜索一次
            helper(chars, len, begin + 1, res);
        }
    }

    /**
     * 将 chars 数组中 index 数位上的字符改变大小写
     *
     * @param chars
     * @param index
     */
    private void change(char[] chars, int index) {
        if (chars[index] >= 97) {
            chars[index] -= 32;
            return;
        }
        if (chars[index] >= 65) {
            chars[index] += 32;
        }
    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        int len = S.length();
        if (len == 0) {
            res.add(S);
            return res;
        }
        char[] chars = S.toCharArray();
        helper(chars, len, 0, res);
        return res;
    }

    public static void main(String[] args) {
        // 97
        System.out.println((int) 'a');
        // 65
        System.out.println((int) 'A');

        Solution solution = new Solution();
        String S = "";
        List<String> letterCasePermutation = solution.letterCasePermutation(S);
        System.out.println(letterCasePermutation);
    }
}
