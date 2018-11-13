import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/permutations-ii/
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] marked;

    private void findPermuteUnique(int[] nums, int depth, Stack<Integer> stack) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!marked[i]) {
                // i > 0 是为了保证 marked[i - 1] 有意义，事实上 i = 0 是一定在解当中的
                // 相当于树被剪枝，重点体会这一步剪枝操作是为什么，其实画个图就非常清楚了
                if (i > 0 && nums[i] == nums[i - 1] && !marked[i - 1]) {
                    continue;
                }
                marked[i] = true;
                stack.add(nums[i]);
                findPermuteUnique(nums, depth + 1, stack);
                stack.pop();
                marked[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        // 这一步很关键，是后面剪枝的基础
        Arrays.sort(nums);
        marked = new boolean[len];
        findPermuteUnique(nums, 0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution solution = new Solution();
        List<List<Integer>> permuteUnique = solution.permuteUnique(nums);
        System.out.println(permuteUnique);
    }
}
