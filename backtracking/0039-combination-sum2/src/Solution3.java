import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/10/11 12:28 下午
 */
public class Solution3 {

    // 不排序版本

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        dfs(candidates, len, target, 0, new Stack<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int len, int residue,
                     int start, Stack<Integer> stack, List<List<Integer>> res) {
        if (residue < 0) {
            return;
        }
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < len; i++) {
            residue -= candidates[i];
            stack.add(candidates[i]);
            dfs(candidates, len, residue, i, stack, res);
            residue += candidates[i];
            stack.pop();
        }
    }
}
