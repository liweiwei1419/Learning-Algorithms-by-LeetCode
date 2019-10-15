import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        help("", n, n, res);
        return res;
    }

    /**
     * @param curString 当前递归得到的结果
     * @param left      左括号还有几个没有用掉
     * @param right     右边的括号还有几个没有用掉
     * @param res       结果集
     */
    private void help(String curString, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(curString);
            return;
        }
        // 还有左括号没有用掉，于是考虑用掉左括号
        if (left > 0) {
            help(curString + "(", left - 1, right, res);
        }
        // 左边括号剩余的比右边括号剩余的少
        // 也就是说，左边括号用得多，于是考虑使用右边括号
        if (left < right) {
            help(curString + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        List<String> generateParenthesis = solution.generateParenthesis(n);
        System.out.println(generateParenthesis);
    }
}