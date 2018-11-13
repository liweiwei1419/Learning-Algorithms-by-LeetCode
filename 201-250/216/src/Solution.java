import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/combination-sum-iii/description/
// 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有1 - 9的正整数，并且每种组合中不存在重复的数字。
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int k;

    private void findCombinationSum3(int target, int depth, int start, Stack<Integer> stack) {
        if (target == 0 && depth == k) {
            res.add(new ArrayList<>(stack));
            return;
        }
        // 注意：题目中要求组合中只允许含有 1 - 9 的正整数。
        for (int i = start; i <= 9 && target - i >= 0; i++) {
            stack.add(i);
            findCombinationSum3(target - i, depth + 1, i + 1, stack);
            stack.pop();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 0 || n < 0 || k > n) {
            return res;
        }

        if (n > (9 * k - (k * (k - 1)) / 2)) {
            return res;
        }

        this.k = k;
        // 注意，深度应该从 0 开始，往下走一层，深度加 1 ，加到 3 为止
        findCombinationSum3(n, 0, 1, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 3;
        int n = 15;
        List<List<Integer>> combinationSum3 = solution.combinationSum3(k, n);
        System.out.println(combinationSum3);
    }
}
