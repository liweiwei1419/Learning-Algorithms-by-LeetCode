import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/10/11 7:56 下午
 */
public class Solution {

    public List<String> letterCasePermutation(String S) {
        int len = S.length();
        List<String> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        char[] charArray = new char[len];
        dfs(S, 0, len, charArray, res);
        return res;
    }

    private void dfs(String S, int start, int len, char[] charArray, List<String> res) {
        if (start == len) {
            res.add(new String(charArray));
            return;
        }
        charArray[start] = S.charAt(start);
        dfs(S, start + 1, len, charArray, res);
        if (Character.isLetter(S.charAt(start))) {
            charArray[start] = (char) (S.charAt(start) ^ (1 << 5));
            dfs(S, start + 1, len, charArray, res);
        }
    }

    public static void main(String[] args) {
        String S = "a1b2";
        Solution solution = new Solution();
        List<String> res = solution.letterCasePermutation(S);
        System.out.println(res);
    }
}
