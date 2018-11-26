import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/subsets-ii/description/
 */
public class Solution2 {

    private void findSubsetsWithDup(int[] nums, int begin, int len, boolean[] marked, Stack<Integer> stack, List<List<Integer>> res) {
        res.add(new ArrayList<>(stack));
        for (int i = begin; i < len; i++) {
            if (!marked[i]) {
                // 去重都有这一步加上排序
                if (i > begin && nums[i] == nums[i - 1]) {
                    continue;
                }
                marked[i] = true;
                stack.add(nums[i]);
                findSubsetsWithDup(nums, i + 1, len, marked, stack, res);
                stack.pop();
                marked[i] = false;
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Arrays.sort(nums);
        boolean[] marked = new boolean[len];
        findSubsetsWithDup(nums, 0, len, marked, new Stack<>(), res);
        return res;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsetsWithDup = solution.subsetsWithDup(nums);
        System.out.println(subsetsWithDup);
    }
}
