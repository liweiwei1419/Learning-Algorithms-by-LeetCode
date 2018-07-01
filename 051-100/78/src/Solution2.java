import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/subsets/description/
 */
public class Solution2 {

    private void findSubsets(int[] nums, int begin, int len, Stack<Integer> stack, List<List<Integer>> res) {
        res.add(new ArrayList<>(stack));
        for (int i = begin; i < len; i++) {
            stack.add(nums[i]);
            findSubsets(nums, i + 1, len, stack, res);
            stack.pop();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        findSubsets(nums, 0, len, new Stack<>(), res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution2 solution = new Solution2();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}
