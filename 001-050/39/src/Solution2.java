import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/combination-sum/description/
public class Solution2 {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    private void findCombinationSum(int target, int start, Stack<Integer> pre) {
        if (target == 0) {
            res.add(new ArrayList<>(pre));
            return;
        }
        // 优化2：在循环的时候做判断，尽量避免系统栈的深度
        for (int i = start; i < len && target - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            findCombinationSum(target - candidates[i], i, pre);
            pre.pop();
        }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // 优化1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution2 solution = new Solution2();
        List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
        System.out.println(combinationSum);
    }
}
