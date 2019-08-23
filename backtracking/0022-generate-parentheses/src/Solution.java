import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 隐式回溯
    // 方法 1：用减法

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        // 这里的 dfs 是隐式回溯
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号还有几个没有用掉
     * @param right  右边的括号还有几个没有用掉
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为是递归函数，所以先写递归终止条件
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // 如果左边还有剩余，继续递归下去
        if (left > 0) {
            // 拼接上一个左括号，并且剩余的左括号个数减 1
            dfs(curStr + "(", left - 1, right, res);
        }
        // 什么时候可以用右边？例如，(((((()，此时 left < right，
        // 不能用等号，因为只有先拼了左括号，才能拼上右括号
        if (right > 0 && left < right) {
            // 拼接上一个右括号，并且剩余的右括号个数减 1
            dfs(curStr + ")", left , right - 1, res);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> res = solution.generateParenthesis(3);
        System.out.println(res);
    }
}
