import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Stack<Integer> stack = new Stack<>();

        backtrack(nums, 0, len, used, stack, res);
        return res;
    }

    private void backtrack(int[] nums, int depth, int len, boolean[] used, Stack<Integer> stack, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                stack.push(nums[i]);

                backtrack(nums, depth + 1, len, used, stack, res);

                stack.pop();
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permute(nums);
        System.out.println(res);
    }
}
