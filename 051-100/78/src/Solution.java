import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/subsets/description/
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int len;
    private int[] nums;

    // 辅助函数
    private void findSubsets(int maxCount, int begin, Stack<Integer> stack) {
        if (maxCount == stack.size()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len; i++) {
            stack.add(nums[i]);
            findSubsets(maxCount, i + 1, stack);
            stack.pop();
        }
    }

    // 主函数
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        this.len = len;
        this.nums = nums;
        for (int i = 0; i <= len; i++) {
            findSubsets(i, 0, new Stack<>());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(nums);
        System.out.println(subsets);
    }
}
