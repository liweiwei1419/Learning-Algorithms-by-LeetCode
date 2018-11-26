import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/subsets-ii/description/
 */
public class Solution {

    private void findSubsetsWithDup(int[] nums, int maxCount, int begin, int len,
                                    boolean[] marked, Stack<Integer> stack,
                                    List<List<Integer>> res) {
        if (maxCount == stack.size()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (!marked[i]) {
                // 去重都有这一步加上排序
                if (i > begin && nums[i] == nums[i - 1]) {
                    continue;
                }
                marked[i] = true;
                stack.add(nums[i]);
                findSubsetsWithDup(nums, maxCount, i + 1, len, marked, stack, res);
                stack.pop();
                marked[i] = false;
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 排序很关键
        Arrays.sort(nums);
        boolean[] marked = new boolean[len];
        for (int i = 0; i <= len; i++) {
            findSubsetsWithDup(nums, i, 0, len, marked, new Stack<>(), res);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsetsWithDup = solution.subsetsWithDup(nums);
        System.out.println(subsetsWithDup);
    }
}
