import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/10/11 1:08 下午
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        // 排序很重要
        Arrays.sort(nums);
        dfs(nums, 0, len, new Stack<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, int len, Stack<Integer> stack, List<List<Integer>> res) {
        res.add(new ArrayList<>(stack));
        for (int i = start; i < len; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            stack.add(nums[i]);
            dfs(nums, i + 1, len, stack, res);
            stack.pop();
        }
    }
}
