import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author liwei
 * @date 2019/8/21 10:23 AM
 */
public class Solution7 {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 使用位图，适用于数组 nums 的长度不超过 32 位的情况
        int used = 0;
        Stack<Integer> stack = new Stack<>();

        backtrack(nums, 0, len, used, stack, res);
        return res;
    }

    private void backtrack(int[] nums, int depth, int len, int used, Stack<Integer> stack, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (((used >> i) & 1) == 0) {
                used ^= (1 << i);
                stack.push(nums[i]);

                backtrack(nums, depth + 1, len, used, stack, res);

                stack.pop();
                used ^= (1 << i);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution7 solution7 = new Solution7();
        List<List<Integer>> res = solution7.permute(nums);
        System.out.println(res);
    }
}
