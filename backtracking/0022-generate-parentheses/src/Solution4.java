import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        helper("", 0, 0, n, res);
        return res;
    }

    /**
     * @param curString
     * @param left      已经使用掉的左边括号数量
     * @param right     已经使用掉的右边括号数量
     * @param n
     * @param res
     */
    private void helper(String curString, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curString);
            return;
        }
        if (left < n) {
            helper(curString + "(", left + 1, right, n, res);
        }
        // 如果左边括号比右边括号多，则可以考虑加上右边括号
        if (left > right) {
            helper(curString + ")", left, right + 1, n, res);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Solution2 solution2 = new Solution2();
        List<String> generateParenthesis = solution2.generateParenthesis(n);
        System.out.println(generateParenthesis);
    }
}
