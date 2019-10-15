import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/10/11 12:37 下午
 */
public class Solution2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        int len = candidates.length;
        dfs(candidates, target, 0, len, new Stack<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int residue, int start, int len, Stack<Integer> stack,
                     List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < len; i++) {
            if (residue - candidates[i] < 0) {
                break;
            }
            // 注意：这里不能写 i > 0
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.add(candidates[i]);
            dfs(candidates, residue - candidates[i], i + 1, len, stack, res);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        Solution2 solution = new Solution2();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println(res);

    }
}
