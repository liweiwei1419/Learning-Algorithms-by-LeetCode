import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/10/11 1:00 下午
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        dfs(nums, 0, len, new Stack<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, int len, Stack<Integer> stack, List<List<Integer>> res) {
        res.add(new ArrayList<>(stack));
        for (int i = start; i < len; i++) {
            stack.add(nums[i]);
            dfs(nums,i + 1,len,stack,res);
            stack.pop();
        }
    }
}
