import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/combination-sum/description/
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    // residue 定义为剩余，这个剩余一开始等于 target，在递归中，它的值会越来越小
    // 因为题目中说了"所有数字（包括 target）都是正整数"。
    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        // 因为可以无限选取，所以 residue 只能小于 0 或者等于 0
        if (residue < 0) {
            return;
        }
        // 一定是剩下的那个数为 0 了，才表示我们所选的数字的和刚好等于 target
        if (residue == 0) {
            res.add(new ArrayList<>(pre));
            return;
        }
        for (int i = start; i < len; i++) {
            // 每个数有选择和不选择，因此尝试了一种解的可能以后要进行状态重置
            pre.add(candidates[i]);
            // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
            findCombinationSum(residue - candidates[i], i, pre);
            pre.pop();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution solution = new Solution();
        List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
        System.out.println(combinationSum);
    }
}
