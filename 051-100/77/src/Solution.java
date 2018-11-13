import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/combinations/description/
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    private void findCombinations(int n, int k, int begin, Stack<Integer> stack) {
        if (stack.size() == k) {
            // 够数了，就添加到结果集中
            res.add(new ArrayList<>(stack));
            return;
        }
        // n - (k - stack.size()) + 1 是一步剪枝操作
        // for (int i = index; i <= n; i++) {
        // 关键在于分析出 i 的上界
        for (int i = begin; i <= n - (k - stack.size()) + 1; i++) {
            stack.add(i);
            findCombinations(n, k, i + 1, stack);
            stack.pop();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        findCombinations(n, k, 1, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }
}
