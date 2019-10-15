import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/10/11 5:22 下午
 */
public class Solution5 {

    // 不剪枝版本

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        dfs(candidates, target, len, 0, new Stack<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int target, int len, int start, Stack<Integer> stack, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < len; i++) {
            stack.add(candidates[i]);
            dfs(candidates, target - candidates[i], len, i, stack, res);
            stack.pop();
        }
    }
}
