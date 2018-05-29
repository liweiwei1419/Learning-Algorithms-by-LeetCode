import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/combination-sum-ii/description/
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;


    private void findCombinationSum2(int target, int begin, Stack<Integer> stack) {
        if (target == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len && target - candidates[i] >= 0; i++) {
            // 这一步之所以能够生效，其前提是数组一定是排好序的，这样才能保证：
            // 在递归调用的统一深度（层）中，一个元素只使用一次。
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.add(candidates[i]);
            findCombinationSum2(target - candidates[i], i + 1, stack);
            stack.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        this.len = len;
        Arrays.sort(candidates);
        this.candidates = candidates;
        findCombinationSum2(target, 0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        // write your code here

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};

        int target = 8;

//        int[] candidates = {2,3,6,7};
//        int target=7;
        Solution solution = new Solution();

        List<List<Integer>> combinationSum2 = solution.combinationSum2(candidates, target);
        System.out.println(combinationSum2);
    }
}
