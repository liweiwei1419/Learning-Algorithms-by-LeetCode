import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/combination-sum-ii/description/
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    // residue 表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
    // residue 在递归遍历中，只会越来越小
    private void findCombinationSum2(int residue, int begin, Stack<Integer> stack) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len && residue - candidates[i] >= 0; i++) {
            // 这一步之所以能够生效，其前提是数组一定是排好序的，这样才能保证：
            // 在递归调用的统一深度（层）中，一个元素只使用一次。
            // 这一步剪枝操作基于 candidates 数组是排序数组的前提下
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.add(candidates[i]);
            // 【关键】因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            findCombinationSum2(residue - candidates[i], i + 1, stack);
            stack.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        this.len = len;
        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);
        this.candidates = candidates;
        findCombinationSum2(target, 0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};
        int target = 5;
        Solution solution = new Solution();
        List<List<Integer>> combinationSum2 = solution.combinationSum2(candidates, target);
        System.out.println(combinationSum2);
    }
}
