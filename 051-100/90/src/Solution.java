import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode-cn.com/problems/subsets-ii/description/
public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] nums;
    private int len;
    private boolean[] used;


    private void findSubsetsWithDup(int maxCount, int begin, Stack<Integer> stack) {
        if (maxCount == stack.size()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (!used[i]) {
                if (i > begin && nums[i] == nums[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.add(nums[i]);
                findSubsetsWithDup(maxCount, i + 1, stack);
                stack.pop();
                used[i] = false;
            }
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        this.len = len;

        Arrays.sort(nums);
        this.nums = nums;
        used = new boolean[len];
        for (int i = 0; i <= len ; i++) {
            findSubsetsWithDup(i, 0, new Stack<>());
        }
        return res;
    }

    public static void main(String[] args) {
        // write your code here

        Solution solution = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> subsetsWithDup = solution.subsetsWithDup(nums);
        System.out.println(subsetsWithDup);
    }
}
