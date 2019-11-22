import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/10/30 5:26 下午
 */
public class Solution8 {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        dfs(nums, 0, len, stack, res);
        return res;
    }

    private void dfs(int[] nums, int index, int len,
                     Stack<Integer> stack, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        // 当前数可选，也可以不选

        // 不选，直接进入下一层
        dfs(nums, index + 1, len, stack, res);

        // 选了有，进入下一层
        stack.add(nums[index]);
        dfs(nums, index + 1, len, stack, res);
        stack.pop();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution8 solution7 = new Solution8();
        List<List<Integer>> subsets = solution7.subsets(nums);
        System.out.println(subsets);
    }
}
