import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/subsets/description/
public class Solution2 {

    private List<List<Integer>> res = new ArrayList<>();
    private int len;
    private int[] nums;

    private void findSubsets(int begin, Stack<Integer> stack) {
        res.add(new ArrayList<>(stack));
        for (int i = begin; i < len; i++) {
            stack.add(nums[i]);
            findSubsets(i + 1, stack);
            stack.pop();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        this.len = len;
        this.nums = nums;
        findSubsets(0, new Stack<>());
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution2 solution = new Solution2();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}
