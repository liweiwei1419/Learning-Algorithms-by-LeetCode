import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution4 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 1、排序
        Arrays.sort(candidates);
        solve(candidates, target, 0, res, new ArrayList<>());
        return res;
    }

    private void solve(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> list) {
        for (int i = start; i < candidates.length; ++i) {
            if (candidates[i] <= target) {
                list.add(candidates[i]);

                if (target - candidates[i] == 0) {
                    // 到叶子结点，剪枝
                    res.add(new ArrayList<>(list));
                } else {
                    int left = target - candidates[i];
                    // 2、left > candidates[i] && left < 2 * candidates[i] ? i + 1 : i，升序，所以当剩余target在当前位置的1~2倍之间的话，如果去掉一个
                    // 当前值，剩下的就小于当前值了，后面肯定没有，所以直接下一个
                    solve(candidates, left, left > candidates[i] && left < 2 * candidates[i] ? i + 1 : i, res, list);
                }
                // 回溯
                list.remove(list.size() - 1);
            } else {
                //升序，所以大的直接返回
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution4 solution = new Solution4();
        List<List<Integer>> combinationSum = solution.combinationSum(candidates, target);
        System.out.println(combinationSum);
    }
}
