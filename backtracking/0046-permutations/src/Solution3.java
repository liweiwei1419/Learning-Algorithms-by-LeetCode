import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class Solution3 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 使用哈希表检测一个数字是否使用过
        Set<Integer> used = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        backtrack(nums, 0, len, used, stack, res);
        return res;
    }

    private void backtrack(int[] nums, int depth, int len, Set<Integer> used, Stack<Integer> stack, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used.contains(i)) {
                used.add(i);
                stack.push(nums[i]);

                backtrack(nums, depth + 1, len, used, stack, res);

                stack.pop();
                used.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        List<List<Integer>> permute = solution4.permute(new int[]{1, 2, 3, 4});
        System.out.println(permute);
        System.out.println(permute.size());
    }
}
